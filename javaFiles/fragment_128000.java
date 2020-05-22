/**
 * Declares Broadcast Reciver for recive location from Location Service
 */
private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Get data from intent
        serviceCounter = intent.getIntExtra("counter", 0);
        // Change TextView
        setText(String.valueOf(counterService));
    }
};