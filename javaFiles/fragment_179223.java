@Override
protected void onCreate(Bundle savedInstanceState) {
....
SharedPreferences preferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
number = preferences.getInt("NUMBER", 0);
}