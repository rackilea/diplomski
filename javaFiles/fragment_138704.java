public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance.getApplicationContext()
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}