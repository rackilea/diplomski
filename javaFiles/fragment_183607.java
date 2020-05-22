private final IntentFilter onSomethingIntentFilter = new IntentFilter(MyService.ACTION_SOMETHING);
private final BroadcastReceiver onSomething = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        // This check seems redundant but it's not. Google it.
        if (MyService.ACTION_SOMETHING.equals(intent.getAction()) {
            // Show toast here.
        }
    }
};

public void onResume() {
    super.onResume();

    // Start listening for events when activity is in foreground.
    LocalBroadcastManager.getInstance(this).registerReceiver(onSomething, onSomethingIntentFilter);
}

public void onPause() {
    super.onPause();

    // Stop listening as soon as activity leaves foreground.
    try {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(onSomething);
    } catch (IllegalArgumentException ex) {}
}