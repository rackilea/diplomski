@Override
protected void onDestroy() {
stopService(playIntent);
musicService = null;
super.onDestroy();
}