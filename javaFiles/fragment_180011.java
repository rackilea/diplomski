public class MainActivity extends AppCompatActivity {
    ListView mListView;

    String [] countries;
    String [] countryNames;
    int [] flagImages;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = getResources().getStringArray(R.array.cList);
        Arrays.sort(countries);
        countryNames = new String[countries.length];
        flagImages = new int[countries.length];

        for (int i = 0; i < countries.length; i++) {
            String[] array = countries[i].split(";");
            countryNames[i] = array[0];
            flagImages[i] = getResources().getIdentifier(array[1], "drawable", getPackageName());
        }

        mListView = findViewById(R.id.listview);

        final MyAdapter myAdapter = new MyAdapter(MainActivity.this, countryNames, flagImages);

        mListView.setAdapter(myAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent mIntent = new Intent(MainActivity.this, SecondActivity.class);
                mIntent.putExtra("countryName", countryNames[i]);
                mIntent.putExtra("flagImage", flagImages[i]);
                startActivity(mIntent);
            }
        });
    }
}