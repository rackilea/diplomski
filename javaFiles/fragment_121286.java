FragmentLeft.java : 
public class FragmentLeft extends Fragment {
    private GoogleMap map;
    GPSTracker gps;
    private SupportMapFragment fragment;
    List<Event> lsEvent=new ArrayList<Event>();
    private double latitude = 0;
    private double longitude = 0;
    private GoogleMap mMap;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View flipMap =inflater.inflate(R.layout.fragment_left, container,false);
        gps = new GPSTracker(getActivity());
        latitude = gps.getLatitude();
        longitude = gps.getLongitude();

        return  flipMap;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map_fragment);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map_fragment, fragment).commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map == null) {
            map = fragment.getMap();
            System.out.println("Latitude : = "+latitude+" Longitude : ="+longitude);
            map.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)));
            LatLng sydney = new LatLng(latitude, longitude);
            map.clear();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 12);
            map.animateCamera(cameraUpdate);
        }
    }
    }