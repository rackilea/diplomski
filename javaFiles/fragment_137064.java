class MyApplication extends Application {
    protected static Context mContext;

    @Override
    public void onCreate() {
       super.onCreate();

       mContext = this;
    }

    public static Context getAppContext() {
       return mContext;
    }
}