public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, getResources().getString(R.string.ParseAppID), getResources().getString(R.string.ParseClientID));

        // Subscribe to a channel
        ParsePush.subscribeInBackground("twofourseven", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("PARSE", "Successfully subscribed to Parse channel");
                } else {
                    Log.d("PARSE", "Failed to subscribe to Parse channel");
                }
            }
        });

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}