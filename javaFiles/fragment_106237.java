package com.example.jniaudiotrack;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class JniAudioTrackActivity extends Activity {
    public AudioTrack mAudioTrack;
    public byte[] mArr;
    public static Handler mHandler = new Handler();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mArr = new byte[2048];
        for (int i = 0; i < 2048; i++) {
            mArr[i] = (byte) (Math.sin(i) * 128);
        }

        mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                    11025,
                    AudioFormat.CHANNEL_CONFIGURATION_MONO,
                    AudioFormat.ENCODING_PCM_8BIT,
                    2048,
                    AudioTrack.MODE_STREAM);
        mAudioTrack.play();

        new Thread(new Runnable() {
            public void run() {
                audioFunc();
            }
        }).start();
    }

    public native void audioFunc();

    @SuppressWarnings("unused")
    private void audioCB() {
        mHandler.post(new Runnable() {
            public void run() {
                mAudioTrack.write(mArr, 0, 2048);
                Log.i(TAG, "*** audioCB called ***");
            }
        });
    }

    private static final String TAG = "JniAudioTrackActivity";

    static {
        System.loadLibrary("jni_audiotrack");
    }
}