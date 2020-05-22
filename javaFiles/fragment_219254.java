googleLocationService = new GoogleLocationService(context, new LocationUpdateListener() {
    @Override
    public void canReceiveLocationUpdates() {
    }

    @Override
    public void cannotReceiveLocationUpdates() {
    }

    //update location to our servers for tracking purpose
    @Override
    public void updateLocation(Location location) {
        if (location != null ) {
            Timber.e("updated location %1$s %2$s", location.getLatitude(), location.getLongitude());

        }
    }

    @Override
    public void updateLocationName(String localityName, Location location) {

        googleLocationService.stopLocationUpdates();
    }
});
googleLocationService.startUpdates();


and call this onDestroy 
if (googleLocationService != null) {
    googleLocationService.stopLocationUpdates();
}