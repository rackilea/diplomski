private WakeLock mWakeLock;

// Activity's onCreate()
@Override
protected void onCreate(Bundle savedInstanceState)
{
    ...
    PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
    mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "worker");
    ...

    // The worker thread
    Thread t = new Thread(mRunnable);
    t.start();
}

@Override
protected void onPause()
{
    super.onPause();
    mWakeLock.acquire();
}

@Override
protected void onResume()
{
    super.onResume();
    if(mWakeLock.isHeld()) mWakeLock.release();
}