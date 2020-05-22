@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    LocalBroadcastManager.getInstance(this)
            .registerReceiver(mReceiver, new IntentFilter(ACTION_SHOW_TEXT));
}

@Override
protected void onDestroy() {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
}