// Supposing that your value is an integer declared somewhere as: int myInteger;
private void sendMessage() {
  // The string "my-integer" will be used to filer the intent
  Intent intent = new Intent("my-integer");
  // Adding some data
  intent.putExtra("message", myInteger);
  LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
}