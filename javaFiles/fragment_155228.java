public class MyClassName {

    BroadcastReceiver batteryInfoReceiverLevel;

    public void CheckBatteryLevel(Context ctx) {

        Log.d("App", "I'm in the CheckBatteryLevel");

        batteryInfoReceiverLevel = new BroadcastReceiver() { // init your Receiver

            @Override
            public void onReceive(Context context, Intent intent) {

                Log.d("Apps", "I'm in the onReceive");
                int level= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                if(level <=100) {
                    //Do something
                } else if(level >=100) {
                    //Do something
                }
            }
        };
        // register your Receiver after initialization 
        ctx.registerReceiver(batteryInfoReceiverLevel,
                  new IntentFilter(Intent.ACTION_BATTERY_CHANGED)); 
    }
}