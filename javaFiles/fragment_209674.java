public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LocationProvider locationProvider = LocationProvider.getInstance();
        locationProvider.configureIfNeeded(this);
    }
}