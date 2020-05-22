String provider;
    public double latitude, longitude = 0;
    CurrentPositionTask getCurrentLocation;
    Location currentLocation;
    LocationListener locationListener;
    LocationManager locationManager;
    private long time=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            setCriteria();
            currentLocation = AndroidLocationActivity.this.locationManager.getLastKnownLocation(provider);

            if (currentLocation == null) {
                currentLocation = new Location(provider);
            }
            time = currentLocation.getTime();

            if (latitude == 0 && longitude == 0) {
                latitude = currentLocation.getLatitude();
                longitude = currentLocation.getLongitude();    
            }
            Toast.makeText(AndroidLocationActivity.this, String.valueOf(time), Toast.LENGTH_LONG).show();