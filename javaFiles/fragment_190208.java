LocationManager locManager;

     @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

      locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
                locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000L,500.0f, locationListener);
                Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);



     if(location != null)                                
            {
                double fromLat = roundTwoDecimals(location.getLatitude());
                double fromLong = roundTwoDecimals(location.getLongitude());
        }

}



// call location listener

  private final LocationListener locationListener = new LocationListener() {
    public void onLocationChanged(Location location) {
        updateWithNewLocation(location);
    }

    public void onProviderDisabled(String provider) {
        Toast.makeText( getApplicationContext(), "GPS is Disabled.Please enable GPS", Toast.LENGTH_SHORT ).show();
        updateWithNewLocation(null);
    }

    public void onProviderEnabled(String provider) {
        Toast.makeText( getApplicationContext(), "GPS is Enabled", Toast.LENGTH_SHORT).show();
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
};