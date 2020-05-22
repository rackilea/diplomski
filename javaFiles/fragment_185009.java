// This goes into the onCreate method
myLocationOverlay = new MyLocationOverlay(this, mapView);
mapView.getOverlays().add(myLocationOverlay);

myLocationOverlay.runOnFirstFix(new Runnable() {
  public void run() {
    mapView.getController().animateTo(myLocationOverlay.getMyLocation());
     }
});