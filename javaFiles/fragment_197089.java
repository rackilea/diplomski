ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    NetworkInfo mMobile = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

    if (mWifi.isConnected() == false && mMobile.isConnected() == false) {
        showDialog(DIALOG_NETWORK_UNAVAILABLE);
    }