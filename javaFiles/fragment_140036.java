Context context;
Button button;
String sender,body,defaultSmsApp;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Get current context
    context = this;

    //Set composant
    button = (Button) findViewById(R.id.button);

    //Get default sms app
    defaultSmsApp = Telephony.Sms.getDefaultSmsPackage(context);

    //Set the number and the body for the sms
    sender = "0042";
    body = "Android fake message";

    //Button to write to the default sms app
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            //Get the package name and check if my app is not the default sms app
            final String myPackageName = getPackageName();
            if (!Telephony.Sms.getDefaultSmsPackage(context).equals(myPackageName)) {

                //Change the default sms app to my app
                Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
                intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, context.getPackageName());
                startActivityForResult(intent, 1);
            }
        }
    });
}

//Write to the default sms app
private void WriteSms(String message, String phoneNumber) {

    //Put content values
    ContentValues values = new ContentValues();
    values.put(Telephony.Sms.ADDRESS, phoneNumber);
    values.put(Telephony.Sms.DATE, System.currentTimeMillis());
    values.put(Telephony.Sms.BODY, message);

    //Insert the message
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        context.getContentResolver().insert(Telephony.Sms.Sent.CONTENT_URI, values);
    }
    else {
        context.getContentResolver().insert(Uri.parse("content://sms/sent"), values);
    }

    //Change my sms app to the last default sms
    Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
    intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, defaultSmsApp);
    context.startActivity(intent);
}

//Get result from default sms dialog pops up
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 1) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {

            final String myPackageName = getPackageName();
            if (Telephony.Sms.getDefaultSmsPackage(context).equals(myPackageName)) {

                //Write to the default sms app
                WriteSms(body, sender);
            }
        }
    }
}