@Override
protected void onStart() {
    super.onStart();
    LocalBroadcastManager.getInstance(this).registerReceiver((receiver), 
        new IntentFilter(YourService.UPDATE_TIME)
    );
}

@Override
protected void onStop() {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    super.onStop();
}