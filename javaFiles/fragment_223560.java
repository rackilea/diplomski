private String android_id;


protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Intent intent = getIntent();
    android_id = Secure.getString(getContentResolver(), Secure.ANDROID_ID);