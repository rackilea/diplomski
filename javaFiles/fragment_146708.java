public class MyApplication extends Application {

    private static MyApplication singleInstance;
    //TODO: Your fields here

    public void onCreate() {
        super.onCreate();
        MyApplication.singleInstance = (MyApplication)getApplicationContext();
        //TODO: Your initialization code here
    }

    public static MyApplication getStaticApplicationContext() {
        return singleInstance;
    }

    //TODO: Your methods here
}