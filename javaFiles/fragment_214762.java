ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

if (mWifi.isConnected()) {
        Intent networkInfoServiceIntent = new Intent(MainActivity.this,NetworkInfoService.class);
        startService(networkInfoServiceIntent);
}