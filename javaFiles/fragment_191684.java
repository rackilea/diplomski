@Override
public void onResume() {
  super.onResume();
  // This registers mMessageReceiver to receive messages.
  LocalBroadcastManager.getInstance(this)
                       .registerReceiver(mMessageReceiver,
                                         new IntentFilter("my-integer"));
}

// Handling the received Intents for the "my-integer" event 
private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
  @Override
  public void onReceive(Context context, Intent intent) {
    // Extract data included in the Intent
    int yourInteger = intent.getIntExtra("message",-1/*default value*/);
  }
};

@Override
protected void onPause() {
  // Unregister since the activity is not visible
  LocalBroadcastManager.getInstance(this)
                       .unregisterReceiver(mMessageReceiver);
  super.onPause();
}