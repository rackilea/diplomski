@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_single_contact);
    // Your bundle code.
    Bundle bundle=getIntent().getExtras();
    String string = bundle.getString("ID",null);
}