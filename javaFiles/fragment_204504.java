private boolean timeReceiverAttached;
private final BroadcastReceiver timeReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        updateClock();
    }
};
private Handler handler = new Handler();

@Override
protected void onResume() {
    super.onResume();
    updateClock();
    if (!timeReceiverAttached) {
        timeReceiverAttached = true;
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        registerReceiver(timeReceiver, filter, null, handler);
    }
}

@Override
protected void onPause() {
    super.onPause();
    if (timeReceiverAttached) {
        unregisterReceiver(timeReceiver);
        timeReceiverAttached = false;
    }
}