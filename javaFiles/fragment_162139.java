public class Constants extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "", "");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}