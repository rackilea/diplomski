package com.pavneet.activitydemo.DB;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.pavneet.activitydemo.R;

/**
 * Created by Pavneet Singh on 20/06/16.
 */
public class TestA extends AppCompatActivity {

    private int i=0;
    private ImageView imageView;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==100){
                i=0;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_ab);
        imageView=(ImageView) findViewById(R.id.imageButtontest);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==0){
                    ++i;
                    handler.sendEmptyMessageDelayed(100,3000); // 3000 equal 3sec , you can set your own limit of secs
                }else if(i==2){
                    Toast.makeText(TestA.this, "Three Touch Clicked" , Toast.LENGTH_SHORT).show();
                    i=0;
                    handler.removeMessages(100);
                }else
                    ++i;
            }
        });

    }
}