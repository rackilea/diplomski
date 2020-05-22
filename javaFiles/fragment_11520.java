package com.example.stack2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    Button test;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.button2);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.button3);
        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.button4);
        b.setOnClickListener(this);
        test = (Button)findViewById(R.id.test);
    }
    public void onClick(View v)
    {
        LayoutParams lp = test.getLayoutParams();
        if(v.getId() == R.id.button1)
        {
            lp.height = LayoutParams.WRAP_CONTENT;
        }else if(v.getId() == R.id.button2){
            lp.width = LayoutParams.WRAP_CONTENT;
        }else if(v.getId() == R.id.button3){
            lp.height = LayoutParams.MATCH_PARENT;
        }else if(v.getId() == R.id.button4){
            lp.width = LayoutParams.MATCH_PARENT;
        }
        test.setLayoutParams(lp);
    }
}