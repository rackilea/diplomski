package com.example.timernew;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Handler h=new Handler();
    TextView t;
    Button start, stop,reset;
    volatile boolean running;
    UpdateTimeTask mUpdateTimeTask;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.TextArea); 
        start = (Button) findViewById(R.id.start_button); 
        stop=(Button) findViewById(R.id.stop_button);
        running=false;

        start.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if (null == mUpdateTimeTask) {
                    mUpdateTimeTask = new UpdateTimeTask();
                    mUpdateTimeTask.execute();
                }
            }
        });

        stop.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(null != mUpdateTimeTask) {
                    mUpdateTimeTask.cancel(true);
                    mUpdateTimeTask = null;
                }
            }
        });

    } 

    public class UpdateTimeTask extends AsyncTask<Void, Void, Void> { 

        protected Void doInBackground(Void... params) {

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Log.e("timer app", "a problem occurred while sleeping or the task was cancelled", ie);
                    return null;
                }
                counter++;
                publishProgress();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            t.setText(String.valueOf(counter));
        }
    }
}