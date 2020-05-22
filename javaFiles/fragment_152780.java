package com.example.developer.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

//NOTE I now implement TextWatch not OnKeyListener
//the AppCompatActivity was changed because ActionBarActivity is deprecated
//look it up on StackOverflow I'll post the link at the bottom of this answer
public class Demo extends AppCompatActivity implements OnClickListener, TextWatcher {

    private TextView textView = null;
    private Button convertButton = null;
    private Button quitButton = null;
    private EditText editText = null;

    private int before = 0;
    private int on = 0;
    private int after = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        textView = (TextView)findViewById(R.id.app_info_tv);
        convertButton = (Button)findViewById(R.id.convert_but);
        quitButton = (Button)findViewById(R.id.quit_but);
        editText = (EditText)findViewById(R.id.main_et);

        convertButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);
        editText.addTextChangedListener(this); //use this instead of OnKeyListener

        Log.d("Demo","in onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //the same as in OP
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //the same as in OP
    }


    @Override
    public void onClick(View v) {
        Log.d("Demo","in onClick");

        //See what View was clicked
        if(v == convertButton) {
            //turn the inputted sting into all Caps
            String textToConvert = editText.getText().toString();
            textToConvert = textToConvert.toUpperCase(Locale.getDefault());
            textView.setText(textToConvert);
            editText.setText("");
        }else if(v == quitButton){
            this.finish();
        }
    }

    //Instead on onKey with OnKeyListener you get three functions with
    //TextWatcher. Like their names suggest one is called before changes,
    //one during, and one after. 

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("****","***************");
        Log.d("Demo","in BTC: "+String.valueOf(before++));
        Log.d("Demo","\ts: "+s.toString());
        Log.d("Demo","\tstart: "+String.valueOf(start));
        Log.d("Demo","\tcount: "+String.valueOf(count));
        Log.d("Demo","\tafter: "+String.valueOf(after));
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("Demo","in OTC: "+String.valueOf(on++));
        Log.d("Demo","\ts: "+s.toString());
        Log.d("Demo","\tstart: "+String.valueOf(start));
        Log.d("Demo","\tcount: "+String.valueOf(count));
        Log.d("Demo","\tbefore: "+String.valueOf(before));
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d("Demo","in ATC: "+after++);
        Log.d("Demo","\ts: "+s.toString());
        String textToConvert = s.toString();
        if(textToConvert.length() > 0 && Character.compare(textToConvert.charAt(textToConvert.length()-1),'\n') == 0){
            onClick(convertButton);
        }
    }
}