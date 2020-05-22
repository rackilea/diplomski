@Override
    public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);SharedPreferences prefs;
    prefs = getSharedPreferences("your_pref", MODE_PRIVATE);

    boolean login_status = prefs.getBoolean("login_status", false);
    if (login_status) {
        Log.v(LOG_TAG, "UserInfo>>User already logged in");
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }
}