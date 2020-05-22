package com.example.macchhindra.stackoverflowexample;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 LinearLayout linearLayout;
 TextView myTextView;
 ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.linerLayout);
        myTextView = (TextView) findViewById(R.id.textId);
        myImageView = (ImageView) findViewById(R.id.imageView);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// change your Image view image in this section
            }
        });
    }
}