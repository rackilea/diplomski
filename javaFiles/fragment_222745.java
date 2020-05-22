...

 Double latitude, longitude;

 @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_location_list);


        if (getIntent() != null) {
            longitude = getIntent().getDoubleExtra("longitude_key", 0); // set to 0 if not found
            latitude = getIntent().getDoubleExtra("latitude_key", 0); // set to 0 if not found
        }