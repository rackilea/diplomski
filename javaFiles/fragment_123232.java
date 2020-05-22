public class MyService extends IntentService {
    public MyService() {
        super("MyService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 3000; i++){
            if(i == 400) {
                sendBroadcast(new Intent("com.example.android.myApp.SOME_KEY"));
            }
        }
    }
}