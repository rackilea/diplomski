import com.google.maps.android.PolyUtil;
//other imports.....

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker;
    List<LatLng> polygonList = new ArrayList<LatLng>();
    //.............