Random rnd = new Random(); 
  int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));  
  --- loop ----

   mMap.addPolyline(new PolylineOptions()
  .add(new LatLng(lats, lons), new LatLng(late,lone))
  .width(5)
  .color(color));