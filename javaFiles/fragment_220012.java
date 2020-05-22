public class RawMapViewDemoActivity extends Activity {
    private MapView mMapView;
    private GoogleMap mMap;

    protected void onCreate(Bundle savedInstanceState) {
        ...
        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);


    protected void onResume() {
        super.onResume();
        mMapView.onResume();

    protected void onPause() {
        mMapView.onPause();
        super.onPause();


    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();


    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();


    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);