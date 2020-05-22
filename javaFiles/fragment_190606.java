public class MyApp extends Application{
    private static Context applicationContext;

    public void onCreate() {
        applicationContext = this;
    }

    public static Context getApplicationContext() {
        return applicationContext;
    }
}