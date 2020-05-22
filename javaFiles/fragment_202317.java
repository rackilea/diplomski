// declare your receiver
private BroadcastReceiver mReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        // do something
    }
};
// add this to your #onCreate(Bundle) in Activity1
LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("someFilter"));