GetMyLocation(Context context) {
    locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);

    this.myLat = location.getLatitude();
    this.myLon = location.getLongitude();

}