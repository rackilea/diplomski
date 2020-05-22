mReceiver = new BroadcastReceiver() {
     public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    if (Intent.ACTION_SCREEN_OFF.equals(action)) {
        //deregister
    }
    else if (Intent.ACTION_SCREEN_ON.equals(action)) {
        //register
    }
}};

IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
registerReceiver(mReceiver, filter); 

filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
registerReceiver(mReceiver, filter);