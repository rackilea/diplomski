private BroadcastReceiver br = new MyBroadcastReceiver();

@Override
public void onCreate() {
  IntentFilter filter = new IntentFilter("com.example.broadcast.MY_NOTIFICATION");
  registerReceiver(br, filter);
}

@Override
public void onDestroy() {
  unregisterReceiver(br);
}

// An inner class at your activity
public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        YourActivity.this.finish();
        // or do anything you require to finish the logout...
    }
}