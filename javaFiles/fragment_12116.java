package com.example.top_tech_deals;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.VideoView;

public class Splash extends Activity{

Thread timer;

@Override
protected void onCreate(Bundle TravisLoveBacon) {
    // TODO Auto-generated method stub
    super.onCreate(TravisLoveBacon);
    setContentView(R.layout.splash);




VideoView vv = (VideoView)this.findViewById(R.id.videoView);

String fileName = "android.resource://" + getPackageName() + "/" + R.raw.splashvid2;

vv.setVideoURI(Uri.parse(fileName));

vv.start();


    timer = new Thread(){
        public void run(){
            try{
                 synchronized (this) {
        wait(12000);
         }

            } catch(InterruptedException e){
                e.printStackTrace();

            } finally{
                Intent openStartingPoint = new Intent     ("android.intent.action.MENU");
                startActivity(openStartingPoint);

            }
        }

    };
    timer.start();
}


//Function that will handle the touch

@Override

public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            synchronized(timer){

                timer.notify();

            }

        }

        return true;
    }


}