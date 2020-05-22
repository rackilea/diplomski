import com.google.android.gms.maps.OnMapReadyCallback;

public class YourActivity extends AppCompatActivity 
    implements OnMapReadyCallback {

    private void SupportMapFragment mMapFragment;
    // private GoogleMap mMap; // Commented so you don't use in onCreate

    @Override
    public void onMapReady(GoogleMap map) {
        // this.mMap = map;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // TODO: call other map setup methods
    }

    // Inside onCreate
        mMapFragment = getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);

        // Don't do this in onCreate
        //  googlemap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

}