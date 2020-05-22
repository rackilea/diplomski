@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    startService(new Intent(getBaseContext(), MediaListenerService.class));
}