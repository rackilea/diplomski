public class TabbedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        // Get text
        String text = getIntent().getStringExtra("YOUR_TEXT"); 

        // Pass text to SectionsPagerAdapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), text);

        .............
        ......................     
    }
}