BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
    @Override public void onReceive(Context context, Intent intent) {
                   //task to do on service stop event 
    }
};
LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, new IntentFilter("SERVICE_STOPPED"));