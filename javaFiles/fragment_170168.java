locationCallback = new LocationCallback(){
    @Override
    public void onLocationResult(LocationResult locationResult) {

        if(locationResult == null) {
          return;
        }
        Location driverLocation = locationResult.getLastLocation();

        if (true) { // TODO: check if button is toggled
            final String value_lat = String.valueOf(driverLocation.getLatitude());
            final String value_lng = String.valueOf(driverLocation.getLongitude());

            ref.child(firebaseUser.getUid()).child("Latitude").setValue(value_lat);
            ref.child(firebaseUser.getUid()).child("Longitude").setValue(value_lng);
        }
    }
};