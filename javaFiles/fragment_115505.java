public class application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       CookieManager cmrCookieMan = new CookieManager(new MyCookieStore(this.objContext), CookiePolicy.ACCEPT_ALL);
       CookieHandler.setDefault(cmrCookieMan);
       }
    }