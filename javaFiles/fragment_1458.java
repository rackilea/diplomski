@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.display);

    TextView v = (TextView) findViewById(R.id.usernd);
    Intent intent = getIntent();
    String username = myIntent.getStringExtra("username");
    v.setText("Welcome" + username);

}