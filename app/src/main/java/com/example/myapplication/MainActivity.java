package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previous;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previous = findViewById(R.id.previousView);
        display = findViewById(R.id.displayView);
        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd){
        String old = display.getText().toString();
        int posi = display.getSelectionStart();
        String left = old.substring(0,posi);
        String right = old.substring(posi);
        display.setText(String.format("%s%s%s",left, strToAdd, right));
        display.setSelection((posi + strToAdd.length()));

    }

    public void zeroBTN(View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void oneBTN(View view){
        updateText(getResources().getString(R.string.one));
    }
    public void twoBTN(View view){
        updateText(getResources().getString(R.string.two));
    }
    public void threeBTN(View view){
        updateText(getResources().getString(R.string.three));
    }
    public void fourBTN(View view){
        updateText(getResources().getString(R.string.four));
    }
    public void fiveBTN(View view){
        updateText(getResources().getString(R.string.five));
    }
    public void sixBTN(View view){
        updateText(getResources().getString(R.string.six));
    }
    public void sevenBTN(View view){
        updateText(getResources().getString(R.string.seven));
    }
    public void eightBTN(View view){
        updateText(getResources().getString(R.string.eight));
    }
    public void nineBTN(View view){
        updateText(getResources().getString(R.string.nine));
    }
    public void addBTN(View view){
        updateText(getResources().getString(R.string.add));
    }
    public void subtractBTN(View view){
        updateText(getResources().getString(R.string.subtract));
    }
    public void multiplyBTN(View view){
        updateText(getResources().getString(R.string.multiply));
    }
    public void divideBTN(View view){
        updateText(getResources().getString(R.string.divide));
    }
    public void percentageBTN(View view){
        updateText(getResources().getString(R.string.percentage));
    }
    public void decimalBTN(View view){
        updateText(getResources().getString(R.string.decimal));
    }
    public void bracketBTN(View view){
        int pos = display.getSelectionStart();
        int open = 0,close = 0,len = display.getText().length();
        for(int i=0;i<pos;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                open+=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                close+=1;
            }
        }
        if((open == close) || (display.getText().toString().substring(len-1,len).equals("("))){
            updateText("(");
            display.setSelection(pos+1);
        }
        else if((open > close) && !(display.getText().toString().substring(len-1,len).equals("("))){
            updateText(")");
            display.setSelection(pos+1);
        }
        display.setSelection(pos+1);
    }
    public void equalBTN(View view){
        String user_exp = display.getText().toString();
        Expression exp = new Expression(user_exp);
        String result = String.valueOf(exp.calculate());

        user_exp = user_exp.replaceAll("√", "sqrt");
        previous.setText(user_exp);

        float check = Float.parseFloat(result);
        int check1 = (int) check;
        if(check == check1){
            display.setText(String.format("%d", check1));
//            display.setSelection(check1.length());
        }
        else{
            display.setText(result);
//            display.setSelection(result.length());
        }

    }
    public void clearBTN(View view){
        display.setText("");
        previous.setText("");
    }
    public void backspaceBTN(View view){
        int pos = display.getSelectionStart();
        int len = display.getText().length();
        if((pos !=0) && (len !=0)){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(pos-1,pos,"");
            display.setText(selection);
            display.setSelection(pos-1);
        }
    }
    public void sinBTN(View view){
        updateText(getResources().getString(R.string.sin));
    }
    public void cosBTN(View view){
        updateText(getResources().getString(R.string.cos));
    }
    public void tanBTN(View view){
        updateText(getResources().getString(R.string.tan));
    }
    public void arcsinBTN(View view){
        updateText(getResources().getString(R.string.arcsin));
    }
    public void arccosBTN(View view){
        updateText(getResources().getString(R.string.arccos));
    }
    public void arctanBTN(View view){
        updateText(getResources().getString(R.string.arctan));
    }
    public void logBTN(View view){
        updateText(getResources().getString(R.string.log));
    }
    public void lnBTN(View view){
        updateText(getResources().getString(R.string.ln));
    }
    public void factorialBTN(View view){
        updateText(getResources().getString(R.string.factorial));
    }
    public void piBTN(View view){
        updateText(getResources().getString(R.string.pi));
    }
    public void powerBTN(View view){
        updateText(getResources().getString(R.string.power));
    }
    public void sqrtBTN(View view){
        updateText(getResources().getString(R.string.sqrt));
    }
}