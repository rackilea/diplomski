public class MenuActivity extends AppCompatActivity {

    public static final String EXTRA_SHOW_BUTTON_KEY = "EXTRA_SHOW_BUTTON_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        final FloatingActionMenu mainFM = (FloatingActionMenu) findViewById(R.id.mainFAB);
        final boolean showButton = getIntent().getBooleanExtra(EXTRA_SHOW_BUTTON_KEY , false);
        mainFM.setVisibility(showButton ? View.VISIBLE : View.INVISIBLE);

        // ...
    }
}