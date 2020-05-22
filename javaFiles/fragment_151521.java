@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    speed = findViewById(R.id.speedtext);
    image = findViewById(R.id.image);

    preferences = getSharedPreferences(Einstellungen.SHARED_PREFERENCES, MODE_PRIVATE);
    int color = preferences.getInt(Einstellungen.SELECTED_COLOR, Color.WHITE);
    speed.setTextColor(color);
    init();
}