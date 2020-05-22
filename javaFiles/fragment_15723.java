ListView lv; // declare as isntance variable
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.connect);
lv = (ListView) findViewById(R.id.list); // initialize