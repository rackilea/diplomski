public class MapFragment extends Fragment {


        public MapFragment() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.fragment_map, container, false);

            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap mMap) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    mMap.clear(); //clear old markers

                    CameraPosition googlePlex = CameraPosition.builder()
                            .target(new LatLng(37.4219999,-122.0862462))
                            .zoom(10)
                            .bearing(0)
                            .tilt(45)
                            .build();

                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);


                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(37.4629101,-122.2449094))
                            .title("Iron Man")
                            .snippet("His Talent : Plenty of money"));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(37.3092293,-122.1136845))
                            .title("Captain America"));
                }
            });


            return rootView;
        }
       }