public class TestMyMoneyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //ParseCrashReporting.enable(getApplicationContext());
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "", "");
        //ParsePush.subscribeInBackground("");
    }
}