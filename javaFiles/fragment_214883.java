package com.example.pushertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionStateChange;

public class MainActivity extends AppCompatActivity {


PusherOptions options = new PusherOptions();

Pusher pusher ;
@Override
protected void onCreate(Bundle savedInstanceState) {
    try {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    options.setCluster("ap3");
    pusher = new Pusher("<key>", options);

    Log.i("PusherConnecting", "Connecting to Pusher");
    pusher.connect();
    Channel channel = pusher.subscribe("my-channel");

        channel.bind("my-event", new SubscriptionEventListener() {
            @Override
            public void onEvent(PusherEvent event) {

                try {

                    Log.i("PusherData", event.getData());
                }
                catch (Exception ex){
                    Log.i("Error", ex.getMessage());
                }

            }
        });
    } catch (Exception ex) {
        Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
    }
}

@Override
protected void onDestroy() {
    pusher.disconnect();
    android.os.Process.killProcess(android.os.Process.myPid());
    System.exit(1);
    super.onDestroy();
}
}