package com.test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.test.MyBoundService

class MainActivity : AppCompatActivity() {


    private val serviceConnection: ServiceConnection = object: ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.i("MainActivity", "Service disconnected")
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            Log.i("MainActivity", "Service connected")
            p1?.let {
                (p1 as MyBoundService.MyBinder).getService().increment()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_create.setOnClickListener {
            val i = Intent(this@MainActivity, MyBoundService::class.java)
            startService(i)
        }

        btn_bind.setOnClickListener {
            val i = Intent(this@MainActivity, MyBoundService::class.java)
            bindService(i, serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onPause() {
        super.onPause()
        unbindService(serviceConnection)
    }
}