public void onMapReady(GoogleMap googleMap) {

     // ... other stuff...

     // check if it already exists in which case do nothing or 
     // unregister it first using LocalBroadcastManager.

     MapRequestReceiver myMapReceiver = new MapRequestsReceiver(googleMap);
     IntentFilter filter = new IntentFilter(MapRequestReceiver.ADD_MARKER);
     filter.addCategory(Intent.CATEGORY_DEFAULT);
     LocalBroadcastManager.getInstance(this).registerReceiver(myMapReceiver, filter);
  }