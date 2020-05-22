@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    Bundle extras = getIntent().getExtras();
    String transportItemChosen = extras.getString("SpinnerValue");
    TextView test = (TextView) findViewById(R.id.Result);
    test.setText(transportItemChosen);
}