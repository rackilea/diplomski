//Note that this is an android.app.Application class.
public class MyApplication extends android.app.Application {

@Override
public void onCreate() {
    super.onCreate();

    //This will only be called once in your app's entire lifecycle.
    Parse.initialize(this,
            getResources().getString(R.string.parse_application_id),
            getResources().getString(R.string.parse_client_key));
}