public class WifiReceiver extends BroadcastReceiver {

    public static boolean connected = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager mgr = (ConnectivityManager) context
            .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = mgr
            .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        connected = networkInfo != null && networkInfo.isConnected();
    }
}

public boolean isConnected(){
    return connected; 
}