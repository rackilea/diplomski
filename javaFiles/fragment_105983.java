public class MyApplication extends Application {
//this method going to be added.
    @Override 
    protected void attachBaseContext(Context base) {
       super.attachBaseContext(base);
       MultiDex.install(this);
    }

}