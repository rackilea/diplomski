package com.example.test;


import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PicturesBeep extends Activity 
{
    private MediaPlayer mMediaPlayer;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
         for(int x = 0; x < 3; x++){
            playAudio();
         }
    }

    private void playAudio () {
        try {
                // http://www.soundjay.com/beep-sounds-1.html lots of free beeps here
            mMediaPlayer = MediaPlayer.create(this, R.raw.beep9);
            mMediaPlayer.setLooping(false);
            Log.e("beep","started0");
            mMediaPlayer.start();
 //           Log.e("beep","started1");
            mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                        public void onCompletion(MediaPlayer arg0) {
                       finish();
                }
        });
        } catch (Exception e) {
            Log.e("beep", "error: " + e.getMessage(), e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}