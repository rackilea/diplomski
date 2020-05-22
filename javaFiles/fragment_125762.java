@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(null);

    loadImageFromSharedPrefernce();
}

private void loadImageFromSharedPrefernce() {
        SharedPreferences prefs = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        if (prefs.contains("imageUrl")){
            String imageUrl = prefs.getString("imageUrl", "");
            loadProfile(imageUrl);    //your method

        }
        else {
            loadProfileDefault();      //your method
        }

    }