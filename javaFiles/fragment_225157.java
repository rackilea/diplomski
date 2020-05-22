@Override
public void onCreate(Bundle savedInstanceState) {

  // Register to receive messages.
  LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
      new IntentFilter("custom-event-name"));
}