public class MainActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (findViewById(R.id.fragment_container) != null) {

            SupportMapFragment mapFragmentClass= new SupportMapFragment ();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, mapFragmentClass).commit();
            getSupportFragmentManager().executePendingTransactions();
            GoogleMap map = mapFragmentClass.getMap();
            // do what you need to do with the map
        }
    }
}