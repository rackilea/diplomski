@Override
public void onLocationChanged(Location location) {
    this.location = location;
    getLatitude();
    getLongitude();

    ParseUser user2 = ParseUser.getCurrentUser();
    ParseGeoPoint geoPoint = new ParseGeoPoint(getLatitude(), getLongitude());
    user2.put("lat_long", geoPoint);
    user2.saveInBackground();




}