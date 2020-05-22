private class MyBroadcastReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    Bundle extras = intent.getExtras();
    String state = extras.getString("extra");
    updateView(state);// update your textView in the main layout 
  }
}