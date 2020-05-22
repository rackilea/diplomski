public class SupportMapFragmentActivity extends FragmentActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_support_map_fragment);

    FragmentManager fmanager = getSupportFragmentManager();
    Fragment fragment = fmanager.findFragmentById(R.id.map);
    SupportMapFragment supportmapfragment = (SupportMapFragment)fragment;
    GoogleMap supportMap = supportmapfragment.getMap();

  }

}