private void sendResult() {
  Log.d("sender", "Broadcasting message");
  Intent intent = new Intent("custom-event-name");
  // You can also include some extra data.
  intent.putExtra("message", "This is my result!");
  LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
}