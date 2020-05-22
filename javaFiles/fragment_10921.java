void mouseMoved() {
  Marker marker = map.getFirstHitMarker(mouseX, mouseY);
  if (marker != null) {
    println(marker.getStringProperty("name"));
  }
}