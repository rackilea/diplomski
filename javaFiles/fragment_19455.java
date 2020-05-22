public class MotherActivity extends FragmentActivity {

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragmenttab = new MainFragment();
        getSupportFragmentManager().beginTransaction()
        .add(R.id.item_detail_container, fragmenttab).commit();


    }