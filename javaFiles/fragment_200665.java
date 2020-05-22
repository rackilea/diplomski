@Override
protected void onCreate() {
    // initialize receiver
    final IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
    filter.addAction(Intent.ACTION_SCREEN_OFF);
    final BroadcastReceiver mReceiver = new MyReceiver();
    registerReceiver(mReceiver, filter);

}