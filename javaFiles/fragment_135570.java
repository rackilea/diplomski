private void setUpMap()  {
    DatabaseHandler db = new DatabaseHandler(this);
    Cursor c  = db.fetchAllAddresses();

    //check for empty cursor
    if (c.getCount() > 0){
      String place = c.getString(c.getColumnIndex("name"));
      Geocoder geocoder = new Geocoder(this, Locale.getDefault());
      List<android.location.Address> addresses = new ArrayList();
      try {
         addresses = geocoder.getFromLocationName(place,1);
      } catch (IOException e) {
         e.printStackTrace();
      }

      android.location.Address add = addresses.get(0);
      double lat = add.getLatitude();
      double lng = add.getLongitude();
      mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("Marker"));
    }

    c.close();  //get rid of memory leak!

 }