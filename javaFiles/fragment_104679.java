public class MainActivity extends Activity {

    public static String REFRESH_ACTIVITY = "com.domain.action.REFRESH_UI"

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // do UI updates
        }
    };

    @Override
    public void onResume() {
        super.onResume();

        // do UI updates

        IntentFilter filter = new IntentFilter();
        filter.addAction(REFRESH_ACTIVITY);
        this.registerReceiver(broadcastReceiver, filter);
    }

    @Override
    public void onPause() {
        super.onPause();

        this.unregisterReceiver(broadcastReceiver);
    }

    ...
}