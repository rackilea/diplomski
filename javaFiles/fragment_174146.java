public MainActivity extends Activity {

    ...

    public static final String ACTION_TEXT_CHANGED = "changed";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ...
        sensorList = (TextView) findViewById(R.id.sensorListView);
        sensorList.setText("\n" + "On create");
        ...
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(ACTION_TEXT_CHANGED));
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String content = intent.getStringExtra("content");
            sensorList.setText("");
        }
    };

}


public class ListenerService extends WearableListenerService {

    ...

    public static final String ACTION_TEXT_CHANGED = "changed";

    ...

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        ...
        retrieveMessage(message);
        ...
    }

    private void retrieveMessage(String message) {
        Intent intent = new Intent();
        intent.setAction(ACTION_TEXT_CHANGED);
        intent.putExtra("content", message);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}