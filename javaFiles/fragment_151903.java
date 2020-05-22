package com.blogspot.techtutorialsajen.androiddevelopmentpractice;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

private Button btn1;
private EditText get;
private TextView result;
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn1 = (Button)findViewById(R.id.btn1);
    result = (TextView)findViewById(R.id.result);
    get = (EditText)findViewById(R.id.get);
 btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (get.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity .this, "Please input something", Toast.LENGTH_LONG).show();
                } else {
                    final double value = Double.parseDouble(get.getText().toString()) / 1000;
                    result.setText(String.valueOf(value));
                }

            }
        });

    }
}