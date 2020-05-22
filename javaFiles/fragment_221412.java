protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_phone_list_custom);

    // Get Extras that were passed in
    Bundle extras = getIntent().getExtras();

    // Not null then we can do stuff with it
    if (extras != null) {
        // Since we passed in a bundle need to get the bundle that we passed in with the key  "KEY"
        Bundle arrayListBundle = extras.getBundle("KEY");
        // and get whatever type user account id is

        // From our Bundle that was passed in can get the two arrays lists that we passed in - Make sure to case to ArrayList or won't work
        ArrayList<String> names = (ArrayList) arrayListBundle.getSerializable("NAMES");
        ArrayList<String> ratings = (ArrayList) arrayListBundle.getSerializable("RATINGS");

        // TODO Make this do more than just log
        Log.i(TAG, "Name=" + names.get(0) + " Rating=" + ratings.get(0));
        Log.i(TAG, "Name=" + names.get(1) + " Rating=" + ratings.get(1));

    }