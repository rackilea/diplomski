public class MyService extends IntentService {

    public MyService() {
        super("MyService");
    }

    public MyService(String name) {
        super(name);        
    }

    @Override
    protected void onHandleIntent(Intent arg0) {

               if (isNetworkAvailable()) {
                    doServiceWork();
                    check("SLeEPING!!!", c);
                }
                else {
                    check ("NO INTERNET", c);
                }

        }
}