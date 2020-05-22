package com.example.tillcounter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 public class TillCounter extends Activity implements OnClickListener{

 Button calcButton;
 EditText readingIn, floatIn, noteIn, fiftiesIn, twentiesIn, tensIn, fivesIn, twosIn,....;       
 TextView resultOut;
 double reading, tillFloat, largeNotes, fifties ,…..;

 @Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_till_counter);

resultOut = (TextView) findViewById(R.id.textView1);
readingIn = (TextView) findViewById(R.id. readingIn);
floatIn = (TextView) findViewById(R.id. floatIn);
noteIn = (TextView) findViewById(R.id. noteIn);
twentiesIn = (TextView) findViewById(R.id. twentiesIn);
///So on


Button calcButton = (Button) findViewById(R.id.calcButton);
calcButton.setOnClickListener(this);

}

 @Override
 public void onClick(View v) {
     Log.i("clicks","You Clicked calculate");
     calculate();
     result = (reading - tillFloat - largeNotes - fifties - twenties - tens -            
         fives - twos      - ones - fiftyC - twentyC - tenC);
     if(result > 0){
     resultOut.setText("The till is up by: " + result);
       }else if(result < 0){
     resultOut.setText("The till is down by: " + result);
     }else{
      resultOut.setText("The till is even at: " + reading);
 }

     Intent i=new Intent(TillCounter.this, ResultActivity.class);
     startActivity(i);
   }
    public void calculate(){
      reading = Double.parseDouble(readingIn.getText().toString());
     tillFloat = Double.parseDouble(floatIn.getText().toString());
      largeNotes = Double.parseDouble(noteIn.getText().toString());
      fifties = Double.parseDouble(fiftiesIn.getText().toString());
      twenties = Double.parseDouble(twentiesIn.getText().toString());
     ////so on
 }

}