public class OsmdroidDemoMap extends Activity {

    private MapView mMapView;
    private MapController mMapController;
    int mIncr = 10000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.osm_main);
        mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setBuiltInZoomControls(true);
        mMapView.setMultiTouchControls(true);
        mMapController = mMapView.getController();
        mMapController.setZoom(13);
        GeoPoint gPt0 = new GeoPoint(51500000, -150000);
        GeoPoint gPt1 = new GeoPoint(gPt0.getLatitudeE6()+ mIncr, gPt0.getLongitudeE6());
        GeoPoint gPt2 = new GeoPoint(gPt0.getLatitudeE6()+ mIncr, gPt0.getLongitudeE6() + mIncr);
        GeoPoint gPt3 = new GeoPoint(gPt0.getLatitudeE6(), gPt0.getLongitudeE6() + mIncr);
        mMapController.setCenter(gPt0);
        PathOverlay myPath = new PathOverlay(Color.RED, this);
        myPath.addPoint(gPt0);
        myPath.addPoint(gPt1);
        myPath.addPoint(gPt2);
        myPath.addPoint(gPt3);
        myPath.addPoint(gPt0);
        mMapView.getOverlays().add(myPath);
    }
}