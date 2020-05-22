public boolean onTap(GeoPoint p, MapView mapView) { 
  Projection projection = mapView.getProjection();
  projection.toPixels(yourMarkerGeopoint, pointTap);
  yourMarker.copyBounds(boundsTap);
  boundsTap.offset(pointTap.x, pointTap.y);
  projection.toPixels(geoPoint, pointTap);
  if(boundsTap.contains(pointTap.x, pointTap.y)){
    //you tap on the marker
    return true;
  }
  return false;
}