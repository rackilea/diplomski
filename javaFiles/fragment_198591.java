//SubActivity onCreate
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Button btn = (Button) findViewById(R.id.Button01);
    btn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences prefs = getSharedPreferences(TestPreferenceActivity.PREFS_FILE, MODE_WORLD_READABLE);
            prefs.edit().putString("mykey", "someValue").commit();
            finish();
        }});
}

//PreferenceActivity onResume
@Override
protected void onResume() {
    Log.d(TAG, "Preferences Resumed");
    //Check for new Preference Values
    SharedPreferences prefs = getSharedPreferences(PREFS_FILE, MODE_WORLD_READABLE);
    String value = prefs.getString("mykey", "defValue");
    Log.d(TAG, "Current value is: " + value);
    super.onResume();
}