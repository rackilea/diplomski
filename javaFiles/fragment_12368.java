class MyFragment extends Fragment {

    private void makeUseOfNewLocation(Location location) {
        // some magic code which uses location object
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        LocationManager locationManager = (LocationManager)activity.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                makeUseOfNewLocation(location);
                locationManager.removeUpdates (this);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}

        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }
}