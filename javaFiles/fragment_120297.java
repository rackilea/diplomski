Intent broadcastIntent = new Intent();
  // get 'lat' and 'lng' from message
  broadcastIntent.setAction(MapRequestsReceiver.ADD_MARKER);
  broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
  broadcastIntent.putExtra("lat", lat);
  broadcastIntent.putExtra("lng", lng);
  LocalBroadcastManager.getInstance( getApplicationContext() ).sendBroadcast(broadcastIntent);