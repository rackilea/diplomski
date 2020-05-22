@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einstellungen);
    preferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
    ...
}