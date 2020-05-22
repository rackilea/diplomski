package com.example.tauben;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class Reminder extends Service {

Handler mHandler;

@Override
public IBinder onBind(Intent arg0) {
    return null;
}
@Override
public void onCreate() {
    mHandler = new Handler();
    Runnable r = new Runnable() {
        @override 
        public void run() {
            f();
            mHandler.postDelayed(this, 10000);
        }
    };
    mHandler.postDelayed(r, 10000);
}
public void f(){
    Toast t = Toast.makeText(this, "Service is still running", Toast.LENGTH_SHORT);
    t.show();
}

}