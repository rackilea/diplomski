public class MainActivity extends Activity
{
    private static final String TAG = "MainActivity";
    private TextView txtvw;
    private BroadcastReceiver receiver;
    private IntentFilter filter;

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = new IntentFilter();
        filter.addAction("BROWSER_STOPPED");

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(TAG, "onReceive");
                Toast.makeText(getApplicationContext(), "Value ", Toast.LENGTH_LONG).show();

                txtvw = (TextView) findViewById(R.id.textView2);
                txtvw.setText("Done");

            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "unregistered");
        unregisterReceiver(receiver);
    }

    protected void onDestroy(){
        super.onDestroy();
    }


    public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }

    public void stopService(View view){
        stopService(new Intent(this,MyService.class));
    }
}