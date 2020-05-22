public class MyService extends Service {
    Locator locator;
    Timer myTimer;
    @Override
    public void onCreate() {
        locator = new Locator();
        myTimer = new Timer();
    }
    ...