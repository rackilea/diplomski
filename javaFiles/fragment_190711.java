@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    lstContent = (ListView) findViewById(R.id.lstContent);

    randomPopulation();
}