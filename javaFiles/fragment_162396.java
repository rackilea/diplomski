public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ConnectivityUtil.init( getApplicationContext());
    }
}