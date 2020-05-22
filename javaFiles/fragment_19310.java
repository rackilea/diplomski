public BroadcastReceiver vibrateReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            vibe.vibrate(pattern, 0);
        }
    }
};

IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
registerReceiver(vibrateReceiver, filter);