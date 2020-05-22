public class NetworkChangeReceiver extends BroadcastReceiver {

    public static boolean isWifiConnected = true;
    public static final String tag = "NETWORKCHANGERECEIVER";

    @Override
    public void onReceive(final Context context, final Intent intent) {

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifi.isConnected()) {
            final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && !(connectionInfo.getSSID().equals(""))) {
                String ssid = connectionInfo.getSSID();
            }
            isWifiConnected = true;
            Log.i("wifi", "connected");
        } else {
            Log.i("wifi", "not connected");
            isWifiConnected = false;
        }
    }
}