public class MyReceiver extends BroadcastReceiver {
    private Context context;

    @Override
    public void onReceive(Context context, Intent arg1) {
        this.context = context;
        createNotification(Calendar.getInstance().getTimeInMillis());
    }

    public void createNotification(long when) {
       // and use 
       // context.getApplicationContext()
    }
 }