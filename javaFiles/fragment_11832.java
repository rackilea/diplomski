public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;
    private Button btnSearchWifi;
    List<ScanResult> results;
    List<String> level;
    List<String> bssid;
    List<String> ssid;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearchWifi = (Button) findViewById(R.id.btnSearchWifi);

        btnSearchWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLocationPermissions();
                detectWifi();

            }
        });
    }

    private void checkLocationPermissions() {
        Log.d(TAG, "checkBTPermissions: checking permission");
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            Log.d(TAG, "checkBTPermissions: build is less than lollipop");
            int permissionCheck = this.checkSelfPermission("Mainifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Mainifest.permission.ACCESS_COARSE_LOCATION");
            if(permissionCheck != 0){
                Log.d(TAG, "checkBTPermissions: permission check failed");
                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number
            }else{
                Log.d(TAG, "checkBTPermissions: no need to check permission. SDK version < Lollipop.");
            }
        }
    }

    public void detectWifi(){
        this.wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(this.wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
            Log.d(TAG, "Wifi State is enabled");

            IntentFilter filter = new IntentFilter();
            filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);

            bssid = new ArrayList<>();
            ssid = new ArrayList<>();
            level = new ArrayList<>();

            registerReceiver(new BroadcastReceiver(){
                @Override
                public void onReceive(Context context, Intent intent) {

                    results = wifiManager.getScanResults();
                    final int N = results.size();

                    Log.v(TAG, "Wi-Fi Scan Results ... Count:" + N);
                    for(int i=0; i < N; ++i) {
                        Log.v(TAG, "  BSSID       =" + results.get(i).BSSID);
                        bssid.add(results.get(i).BSSID);
                        Log.v(TAG, "  SSID        =" + results.get(i).SSID);
                        ssid.add(results.get(i).SSID);
                        Log.v(TAG, "  Level       =" + results.get(i).level);
                        level.add(String.valueOf(results.get(i).level));
                    }
                    SendToLists();
                }
            }, filter);


            // start WiFi Scan
            wifiManager.startScan();

        }else {
            Log.d(TAG, "Wifi State is not enabled");
        }
    }

    public void SendToLists(){
        AdapterElement adapterElements = new AdapterElement(this,ssid,bssid,level);
        ListView netList = (ListView) findViewById(R.id.listView);
        netList.setAdapter(adapterElements);
    }

}