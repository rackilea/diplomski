@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_product);

    preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    timestamp= preferences.getString("timestamp", "");

    if (!timestamp.equals("")) {
        Toast.makeText(getApplicationContext(), timestamp + "iffff", Toast.LENGTH_LONG).show();
    } else {
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("timestamp", ts);
        editor.commit();
        timestamp = preferences.getString("timestamp", "");

        Toast.makeText(getApplicationContext(), timestamp + "elseee", Toast.LENGTH_LONG).show();

    }
}