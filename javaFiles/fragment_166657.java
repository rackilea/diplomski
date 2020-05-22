@Override
   public void onLocationChanged(Location location) { 
       if (lastLocationloc == null) { 
           lastLocationloc = location;
       }
       LatLng lastLatLng = locationToLatLng(lastLocationloc);
       LatLng thisLatLng = locationToLatLng(location);
       mMap.addPolyline(new PolylineOptions().add(lastLatLng).add(thisLatLng).width(3).color(Color.RED));
       lastLocationloc = location;
   }