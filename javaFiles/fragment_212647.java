lat = mLastLocation.getLatitude();
lon = mLastLocation.getLongitude();

geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
List<Address> addresses = null;
try {
    addresses = geocoder.getFromLocation(lat, lon, 1);
} catch (IOException e) {
    e.printStackTrace();
}