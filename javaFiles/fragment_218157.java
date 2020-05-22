public void onStatus(Status status) {
  if(status.getGeoLocation != null) {
    double latitude = status.getGeoLocation.getLatitude();
    double longitude = status.getGeoLocation.getLongitude();
    // use these values
  }
}