public class NLService extends NotificationListenerService {

static Handler mHandler;

    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();

        displayToast("Service Started NL");

    }

@Override
public void onNotificationPosted(final StatusBarNotification sbn) {

    mHandler.post(new Runnable() {            
        @Override
        public void run() {
            Toast.makeText(getApplicationContext(), "Hello Toast!", Toast.LENGTH_LONG).show();                
        }
    });


}
}