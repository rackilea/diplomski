@Override
protected void onResume() {
    // Listen if someone sends data
    LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.localBroadcastReceiver, SIGNAL_FILTER);
}

@Override
protected void onPause() {
    // I'm going to the background / or being destroyed: no need to listen to anything anymore...

    LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.localBroadcastReceiver);
}