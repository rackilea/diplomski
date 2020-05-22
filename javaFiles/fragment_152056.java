public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.findViewById(R.id.image).setVisibility(View.GONE);
        toolbar.postDelayed(new Runnable() {
            @Override
            public void run() {

  toolbar.findViewById(R.id.image).setVisibility(View.VISIBLE);
            }
        }, 5000);
    }
}