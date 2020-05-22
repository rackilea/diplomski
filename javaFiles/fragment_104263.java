public class MyApp extends Application {
 private static Context mContext;

    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext() {
      //  return instance.getApplicationContext();
      return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    //  instance = this;
     mContext = getApplicationContext();    
    }