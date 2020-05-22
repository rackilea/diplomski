MapView mapView;
GoogleMap map;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.some_layout, container, false);

    // Gets the MapView from the XML layout and creates it
    mapView = (MapView) v.findViewById(R.id.mapview);
    mapView.onCreate(savedInstanceState);

    // Gets to GoogleMap from the MapView and does initialization stuff
    map = mapView.getMap();
}