public boolean onMarkerClick(Marker marker) {

  if(markerClicked){

   if(polyline != null){
    polyline.remove();
    polyline = null;
   }

   rectOptions.add(marker.getPosition());
   rectOptions.color(Color.RED);
   polyline = myMap.addPolyline(rectOptions);
  }else{
   if(polyline != null){
    polyline.remove();
    polyline = null;
   }

   rectOptions = new PolylineOptions().add(marker.getPosition());
   markerClicked = true;
  }

  return true;
 }

}