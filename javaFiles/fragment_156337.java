public class MapActivity extends GeneralActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // I want to be able to display the MapFragment inside this activity
        // What Should I Do Here????
        // enter code here
        setContentView(R.layout.activity_map);

        Fragment fragment = new MapFragment();
        FragmentManager manager = getSupportFragmentManager(); 

        manager.beginTransaction()
                .replace(R.id.frag_container, fragment)
                .commit();

    }
}