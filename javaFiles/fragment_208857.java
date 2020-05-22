public class MapsActivity extends MapActivity {
     private MapView map;
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.maps_layout);
         map = (MapView) findViewById(R.id.map);
         map.setBuiltInZoomControls(true);
     }