@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    LinearLayout contentLayout = (LinearLayout) findViewById(R.id.contentLayout);
    m_mapView = new MapView(this, 10);
    m_mapView.setTileSource(TileSourceFactory.MAPNIK);
    org.osmdroid.views.MapView.LayoutParams mapParams = new org.osmdroid.views.MapView.LayoutParams(
            org.osmdroid.views.MapView.LayoutParams.MATCH_PARENT,
            org.osmdroid.views.MapView.LayoutParams.MATCH_PARENT,
            null, 0, 0, 0);
    m_mapView.setBuiltInZoomControls(true);
    m_mapView.setMultiTouchControls(false);     
    m_mapController = this.m_mapView.getController();
    m_mapController.setZoom(15);
    m_mapView.getController().setCenter( new GeoPoint(51496994, -134733));
    m_mapView.invalidate();
    contentLayout.addView(m_mapView, mapParams);
}