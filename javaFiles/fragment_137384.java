MapView rosterMapView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_roster);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_roster);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    rosterMapView = (MapView) findViewById(R.id.roster_map_view);
    rosterMapView.onCreate(savedInstanceState);
}

@Override
protected void onPause() {{
    super.onPause();
    rosterMapView.onPause();
}