private GoogleMap mMap;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.basic_demo);

    SupportMapFragment mapFragment =
            (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

    if (savedInstanceState == null) {
        // First incarnation of this activity.
        mapFragment.setRetainInstance(true);
    } else {
        // Reincarnated activity. The obtained map is the same map instance in the previous
        // activity life cycle. There is no need to reinitialize it.
        mMap = mapFragment.getMap();
    }
    setUpMapIfNeeded();
}

@Override
protected void onResume() {
    super.onResume();
    setUpMapIfNeeded();
}

private void setUpMapIfNeeded() {
    if (mMap == null) {
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();
        if (mMap != null) {
            // Enabling MyLocation Layer of Google Map
            map.setMyLocationEnabled(true);
        }
    }
}