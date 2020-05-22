// initialize in constructor
    private BroadcastReceiver myReceiver = new MyReceiver();

    // in onCreate, register the receiver
    this.registerReceiver(myReceiver, new IntentFilter(Service.MYCONSTANT));

    // then have a class to receive the broadcast
    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
        //do stuff          
        }
}