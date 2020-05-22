@Override
    protected void onCreate() {
        // initialize receiver
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new ScreenReceiver();
        registerReceiver(mReceiver, filter);
        //NEW
        PowerManager pm =(PowerManager) getSystemService(Context.POWER_SERVICE);
        // your code
    }
    @Override
    protected void onPause() {
        // when the screen is about to turn off
        // Use the PowerManager to see if the screen is turning off
        if (pm.isScreenOn() == false) {
            // this is the case when onPause() is called by the system due to the screen turning off
            System.out.println(“SCREEN TURNED OFF”);
        } else {
            // this is when onPause() is called when the screen has not turned off
        }
        super.onPause();
    }