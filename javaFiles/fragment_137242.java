protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);

       // your code here...
    setContentView(R.layout.activity_main);   //<< set layout for Activity here

    AlarmHelper helper = new AlarmHelper(MainActivity.this);
    helper.setupDatePicker();


}