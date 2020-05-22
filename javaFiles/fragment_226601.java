geoFire.getLocation("location", new LocationCallback() {
    @Override
    public void onLocationResult(String key, GeoLocation location) {
        if (location != null) {
            System.out.println(String.format("The location for key %s is [%f,%f]", key, location.latitude, location.longitude))
// save longitude and latitude to db
            Double longi = location.longitude;
            Double lat = location.latitude
        } else {
            System.out.println(String.format("There is no location for key %s in GeoFire", key));
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.err.println("There was an error getting the GeoFire location: " + databaseError);
    }
});