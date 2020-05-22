protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
contactSpinner = (Spinner) findViewById(R.id.contact_list);
contactSpinner.setOnItemSelectedListener(this);  
....