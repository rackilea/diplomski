public class MapsActivity extends AppCompatActivity
        implements ClusterManager.OnClusterItemInfoWindowClickListener<MyItem> {

    private ClusterManager<MyItem> mClusterManager;
    private MyItem clickedClusterItem;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }

        }
    }

    private void setUpMap() {

        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mClusterManager = new ClusterManager<>(this, mMap);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.779977,-122.413742), 10));

        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);

        mMap.setInfoWindowAdapter(mClusterManager.getMarkerManager());

        mMap.setOnInfoWindowClickListener(mClusterManager); //added
        mClusterManager.setOnClusterItemInfoWindowClickListener(this); //added

        mClusterManager
                .setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
                    @Override
                    public boolean onClusterItemClick(MyItem item) {
                        clickedClusterItem = item;
                        return false;
                    }
                });



        addItems();

        mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(
                new MyCustomAdapterForItems());

    }

    private void addItems() {

        double latitude = 37.779977;
        double longitude = -122.413742;
        for (int i = 0; i < 10; i++) {
            double offset = i / 60d;

            double lat = latitude + offset;
            double lng = longitude + offset;
            MyItem offsetItem = new MyItem(lat, lng, "title " + i+1, "snippet " + i+1);
            mClusterManager.addItem(offsetItem);

        }

    }

    //added with edit
    @Override
    public void onClusterItemInfoWindowClick(MyItem myItem) {

        //Cluster item InfoWindow clicked, set title as action
        Intent i = new Intent(this, OtherActivity.class);
        i.setAction(myItem.getTitle());
        startActivity(i);

        //You may want to do different things for each InfoWindow:
        if (myItem.getTitle().equals("some title")){

            //do something specific to this InfoWindow....

        }

    }

    public class MyCustomAdapterForItems implements GoogleMap.InfoWindowAdapter {

        private final View myContentsView;

        MyCustomAdapterForItems() {
            myContentsView = getLayoutInflater().inflate(
                    R.layout.info_window, null);
        }
        @Override
        public View getInfoWindow(Marker marker) {

            TextView tvTitle = ((TextView) myContentsView
                    .findViewById(R.id.txtTitle));
            TextView tvSnippet = ((TextView) myContentsView
                    .findViewById(R.id.txtSnippet));

            tvTitle.setText(clickedClusterItem.getTitle());
            tvSnippet.setText(clickedClusterItem.getSnippet());

            return myContentsView;
        }

        @Override
        public View getInfoContents(Marker marker) {
            return null;
        }
    }
}