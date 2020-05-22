@Override
protected void onPause() {
  super.onPause();
  unregisterReceiver(receiver);
}

@Overrride
public void onResume(){
  super.onResume();
  registerReceiver(receiver, filter);
}