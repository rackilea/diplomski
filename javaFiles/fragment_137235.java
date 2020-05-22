private String provider;
private Location mCurrentLocation;
private LocationManager locationManager;
private double radius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            if (b.containsKey("radius")) {
                 radius = b.getDouble("radius");
            }
        }
        SupportMapFragment mfrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = mfrag.getMap();

        googleMap.setMyLocationEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        // Here starts the old code
        //Criteria criteria = new Criteria();
        //provider = locationManager.getBestProvider(criteria, false);
        //locationManager.requestLocationUpdates(provider, 5000, 5, this);
        //mCurrentLocation = locationManager.getLastKnownLocation(provider);
        //if (mCurrentLocation != null) {
        //      onLocationChanged(mCurrentLocation);
        //}         
    }

    // Part of the new code
    @Override
    protected void onResume() {
        super.onResume();
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        locationManager.requestLocationUpdates(provider, 500, 0, this);
    }

    @Override
    public void onLocationChanged(Location location) {
          setMarker("Locality", "Country", location.getLatitude(), location.getLongitude();
          locationManager.removeUpdates(this);
    }