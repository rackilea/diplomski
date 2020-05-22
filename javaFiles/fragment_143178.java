locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
Criteria criteria = new Criteria();
criteria.setAccuracy(Criteria.ACCURACY_FINE);
provider =  locationManager.getBestProvider(criteria, false);
Location location = locationManager.getLastKnownLocation(provider);
VehicleListener vl = new VehicleListener();
locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, vl);

if (location != null) {
    System.out.println("Provider " + provider + " has been selected.");
    lat =location.getLatitude();
    lon = location.getLongitude();
}