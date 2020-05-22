protexted void onCreate(Bundle savedInstanceState) {
    MainApp ma = (MainApp)getApplication();
    if(!ma.isSent) {
        // send sms

        // then set the flag
        ma.isSent = true;
    }

    finish();
}