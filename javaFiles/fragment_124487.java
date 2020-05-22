package com.sample.view;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class Test3 extends Activity {

    ImageView imageview1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);     
        imageview1=(ImageView)findViewById(R.id.imageView1);        
        mHandler = new Handler();       

                imageview1.setVisibility(View.VISIBLE);     

                 startPlay();
    }

    int mThumbIds[]={R.drawable.ic_launcher,R.drawable.home,R.drawable.green        
    };
     int i =0;    
        private Handler mHandler;
     private void startPlay(){

            final Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                Log.i("Test", "Sample= " +i);                   
                    play(i);
                    if(i==2){

                        timer.cancel();
                        startPlay(); //for continuous play. infinite play 
                        i=0;// resetting the values
                    }
                    else{
                    i++;
                    }

            }

            }, 1800, 1800); // here is the duration whcih you want to change the images. 

        }
        private void play(final int round){
            mHandler.post(new Runnable(){
                public void run(){

                    imageview1.setImageResource(mThumbIds[round]);
                    Animation hyperspaceJump1 = AnimationUtils.loadAnimation(Test3.this,android.R.anim.fade_in);                
                    imageview1.startAnimation(hyperspaceJump1); 
                }
            });
        }

}