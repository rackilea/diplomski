public class TabbedActivity extends AppCompatActivity {

    ArrayList<String> stringArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        stringArray = new ArrayList<String>();

        // Get texts
        String textOPIS = getIntent().getStringExtra("OPIS");
        String textSIMPTOMI = getIntent().getStringExtra("SIMPTOMI"); 
        String textUZROCI = getIntent().getStringExtra("UZROCI"); 
        String textLIJECENJE = getIntent().getStringExtra("LIJECENJE"); 

        // Add text to ArrayList
        stringArray.add(textOPIS); 
        stringArray.add(textSIMPTOMI); 
        stringArray.add(textUZROCI); 
        stringArray.add(textLIJECENJE); 

        // Pass ArrayList to SectionsPagerAdapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), stringArray);

        .............
        ......................     
    }
}