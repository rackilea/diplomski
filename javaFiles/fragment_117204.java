private final IntentFilter filter =
          new IntentFilter(LocationManager.MODE_CHANGED_ACTION);

private final BroadcastReceiver receiver = new BroadcastReceiver() {
   @Override public void onReceive(Context context, Intent intent) {
       if(LocationManager.MODE_CHANGED_ACTION.equals(intent.getAction()) {
            // check here the new location status
       }
   }
};

// then to register
context.registerReceiver(receiver, filter);
/// and unregister
context.unregisterReceiver(receiver);