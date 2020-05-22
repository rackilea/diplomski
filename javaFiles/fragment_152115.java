public class MainActivity extends AbsRuntimePermission  implements ZXingScannerView.ResultHandler{

    private String resultCode;
    private Button getBtn;
    private TextView result;
    private OkHttpClient client;
    boolean doubleTap = false;
    private ZXingScannerView scannerView;
    private static final int REQUEST_PERMISSION = 10;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        getBtn = (Button) findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getWebService();
            }
        });
        client = new OkHttpClient();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        requestAppPermissions(new String[]{
                        Manifest.permission.CAMERA},
                R.string.msg, REQUEST_PERMISSION);
    }

    @Override
    public void onBackPressed() {
        if (doubleTap) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Druk Terug opnieuw om de app te sluiten", Toast.LENGTH_SHORT).show();
            doubleTap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                }
            }, 500);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void browser1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.suppliance.nl/"));
        startActivity(browserIntent);
    }

    public void scanCode(View view) {
        scannerView = new ZXingScannerView(this);
        //scannerView.setResultHandler(new ZxingScannerResultHandler());
        scannerView.setResultHandler(this);

        setContentView(scannerView);
        scannerView.startCamera();
    }

    //class ZxingScannerResultHandler implements ZXingScannerView.ResultHandler {
        @Override
        public void handleResult(Result result) {
           // String resultCode = result.getText();
           // Toast.makeText(MainActivity.this, resultCode, Toast.LENGTH_SHORT).show();
            resultCode = result.getText();
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            scannerView.stopCamera();
        }
    //}



    private void getWebService() {

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .appendPath(getString(R.string.ipadres))
                .appendPath(getString(R.string.poort))
                .authority("barcode/")
                .appendPath(getString(R.id.))
        String URL = builder.build().toString();

        final Request request = new Request.Builder().url("http://192.168.17.12:9083/barcode/8712345501006").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText("Mislukt");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            result.setText(response.body().string());
                        } catch (IOException ioe) {
                            result.setText("Error tijdens verkrijgen body");
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        //Do anything when permisson granted
        Toast.makeText(getApplicationContext(), "Toegang geaccepteerd", Toast.LENGTH_LONG).show();
    }
}