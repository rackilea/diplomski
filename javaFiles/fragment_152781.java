public class MyApplication extends Application {
    public static MyApplication context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
   }
}