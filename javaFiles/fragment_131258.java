public static boolean checkNetworkStatus(Context context) {

    ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


    boolean networkIsMobile = false;
    boolean networkIsWiFi = false;
    if (wifi != null && wifi.isAvailable() && wifi.isConnected()) {
        networkIsWiFi = true;
    }
    if (mobile != null && mobile.isAvailable() && mobile.isConnected()) {
        networkIsMobile = true;
    }


    boolean networkActive = networkIsMobile || networkIsWiFi;

    return networkActive;
} // End of checkNetworkStatus