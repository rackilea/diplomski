// This can run outside UI Thread
public static void enableWifi(Context context) {
   WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
   wifi.setWifiEnabled(true);
}

// This must run on UI Thread
public static void verifyWifi(Context context) {
    WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    WifiInfo conn = wifi.getConnectionInfo();
    CharSequence wifi_on = "Connected to " + conn.getSSID();
    int duration = Toast.LENGTH_LONG;

    Toast.makeText(context, wifi_on, duration).show();
}