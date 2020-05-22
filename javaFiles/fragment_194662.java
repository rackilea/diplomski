package com.test

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyBoundService : Service() {

    abstract class MyBinder: Binder() {
        abstract fun getService(): MyBoundService
    }

    val iBinder: MyBinder = object: MyBinder() {
        override fun getService(): MyBoundService {
            return this@MyBoundService
        }
    }

    private var counter = 0

    fun increment() {
        counter ++
        Log.i("MyBoundService", "Counter: ${counter}")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("MyBoundService", "startCommand");
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        counter++
        Log.i("MyBoundService", "Bound: ${counter}")
        return iBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i("MyBoundService", "Unbound")
        return super.onUnbind(intent)
    }
}