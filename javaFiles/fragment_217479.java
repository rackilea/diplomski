@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_auth);

    try {
        myinit(this)
    } catch(SomeException ex) {
        // Handle exception. Like do some UI notification if its a user input exception.
    }

}