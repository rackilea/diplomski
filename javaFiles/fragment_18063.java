map.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
  @Override
  public void onMapLoaded() {
      map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 30));
  }
});