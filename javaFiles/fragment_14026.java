public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresults);

        String value = null;

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
          value = extras.getString("hotelName");
        }

        Toast.makeText(getApplicationContext(),value, Toast.LENGTH_SHORT).show();