BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Log.e("this works", "SCREENSHOT");
            ((TextView) findViewById(R.id.tv13)).setText("SCREENSHOT");
        }
    };
    IntentFilter filter = new IntentFilter(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
    filter.addDataScheme("file");
    registerReceiver(receiver, filter);