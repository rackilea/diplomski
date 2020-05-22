@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layoutname);
    Intent intent = getIntent();
    String firstName = intent.getStringExtra("firstName");
    String lastName = intent.getStringExtra("lastname");
}