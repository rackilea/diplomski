public class MainActivity extends Activity {
    public static final String NOTIFY_ACTIVITY_ACTION = "notify_activity";
    private BroadcastReciver broadcastReciver;


 @Override
protected void onStart() {
    super.onStart();
    broadcastReciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction.equals(NOTIFY_ACTIVITY_ACTION ))
            {
             //to do smth
            }
        }
    }

    IntentFilter filter = new IntentFilter( NOTIFY_ACTIVITY_ACTION );
    registerReceiver(broadcastReciver, filter);
}

@Override
protected void onStop()
{
 unregisterReceiver(broadcastReciver);
}


}