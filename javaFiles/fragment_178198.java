@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choose_subject);

    // Check the state of the activity bundle
    if(savedInstanceState != null) { // the activity has already be created
         loginID = savedInstanceState.getString("SAVED_LOGINID");
         role = savedInstanceState.getInt("SAVED_ROLE");
    } else { // the activity is displayed for the 1st time
         loginID = getIntent().getExtras().getString("LOGINID");
         role = getIntent().getExtras().getInt("ROLE");
    }
    //...
}