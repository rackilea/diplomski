package example.stackoverflow.osmdroid;

import android.app.Activity;
import android.os.Bundle;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class YourMap extends Activity {
    // The MapView variable:
    private MapView m_mapView;

    // Default map zoom level:
    private int MAP_DEFAULT_ZOOM = 15;

    // Default map Latitude:
    private double MAP_DEFAULT_LATITUDE = 38.535350;

    // Default map Longitude:
    private double MAP_DEFAULT_LONGITUDE = -121.753807;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Specify the XML layout to use:
        setContentView(R.layout.osm_map);

        // Find the MapView controller in that layout:
        m_mapView = (MapView) findViewById(R.id.mapview);

        // Setup the mapView controller:
        m_mapView.setBuiltInZoomControls(true);
        m_mapView.setMultiTouchControls(true);
        m_mapView.setClickable(true);
        m_mapView.setUseDataConnection(false);
        m_mapView.getController().setZoom(MAP_DEFAULT_ZOOM);
        m_mapView.getController().setCenter(
            new GeoPoint(MAP_DEFAULT_LATITUDE, MAP_DEFAULT_LONGITUDE));
        m_mapView.setTileSource(TileSourceFactory.MAPNIK);
    } // end onCreate()
} // end class YourMap