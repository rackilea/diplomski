TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mysecondlayout);
    tv = (TextView) findViewByid(R.id.textView1);
    Bundle extras = getIntent().getExtras();
    if (extras != null) {
    String value = extras.getString("key");
    tv.setText(value);
    //get the value based on the key
    }