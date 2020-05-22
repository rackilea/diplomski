@Override
protected void onPause() {
  // Unregister since the activity is not visible
  LocalBroadcastManager.getInstance(this).unregisterReceiver(onComplete);
  super.onPause();
}