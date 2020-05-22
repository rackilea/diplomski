@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_profile);


    String fromActivity = getIntent().getStringExtra("FROM_ACTIVITY");

    if(fromActivity.equals("B")) {
        // Do something
    } else if(fromActivity.equals("C")) {
        // Do something
    }
}