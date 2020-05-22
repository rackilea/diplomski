public class MainActivity extends AppCompatActivity 
    implements LocationListener {

    private LocationsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // adapter = new LocationsAdapter();
    } 

    public LocationsAdapter getLocationsAdapter() { return adapter; } 

     // onLocationChanged... Add to adapter