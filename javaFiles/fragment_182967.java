public class CarLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Marker> markers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car2_go_location);

        SupportMapFragment mapFragment = 
            (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Send parameter if needed
        String param = .... 
        new DisplayMarkersTask(param).execute();
    }

    private static class DisplayMarkersTask extends AsyncTask<String, Void, ArrayList<LatLng>> {

        private WeakReference<CarLocation> mActivityRef;
        public DisplayMarkersTask(CarLocation activity){
            mActivityRef = new WeakReference<>(activity);
        }

        @Override
        protected ArrayList<LatLng> doInBackground(String... params) {
            Take parameter if needed
            String param = params[0];
            ....
            Fetch your json here

            ArrayList<LatLng> latlongList = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                JSONObject marker = placemarks.getJSONObject(j);
                JSONArray coordinates = marker.optJSONArray("coordinates");
                double lat = coordinates.optDouble(0);
                double lng = coordinates.optDouble(1);
                latlongList.add(new LatLng(lat, lng));
            }
            return latlongList;
        }

        @Override
        protected void onPostExecute(ArrayList<LatLng> list) {
            CarLocation activity = mActivityRef.get();
            if(activity == null){
                return;
            }

            for (int j = 0; j <= list.size(); j++) {
                LatLng position = list.get(j);
                Marker marker = activity.mMap.addMarker(
                    new MarkerOptions().position(position));

                activity.markers.add(marker);
            }
        }
    }
}