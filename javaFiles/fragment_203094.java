public class MapActivity extends AppCompatActivity imeplements OnMapReadyCallback, GoogleMap.InfoWindowAdapter {

    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstaceState);
        setContentView(r.layout.activity_map);

        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setInfoWindowAdapter(this);
        mGoogleMap = googleMap;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null; // Use default info window background
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = getLayoutInflater().inflate(R.layout.info_window_multiline, null);

        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        TextView snippetTextView = (TextView) view.findViewById(R.id.snippet);

        titleTextView.setText(marker.getTitle());
        snippetTextView.setText(marker.getSnippet());

        return view;
    }

}