private BroadcastReceiver receiver;

@Overrride
public void onCreate(Bundle savedInstanceState){


  IntentFilter filter = new IntentFilter();
  filter.addAction("android.intent.action.TIME_TICK");

  receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
      // TODO : codes runs every minutes
    }
  }
     registerReceiver(receiver, filter);
}

@Override
protected void onDestroy() {
  super.onDestroy();
  unregisterReceiver(receiver);
}