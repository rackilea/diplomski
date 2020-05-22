protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    db = new MyDbAdapter(this);
    db.open();
    //fillData(); move this
    Bundle extras = getIntent().getExtras();
    mIntentString = extras.getString("contactId");
    contactId = extras.getString("contactId");
    fillData(); //to here
}