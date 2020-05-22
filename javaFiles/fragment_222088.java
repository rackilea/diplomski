public class NetworkChangeReciever extends BroadcastReceiver {

private final static String TAG = "NetworkChangeReciever";

public interface NetworkChangeRecieverListener {

    public void OnNetworkChangeReciever(boolean wifiConnected);
}


@Override
public void onReceive(final Context context, final Intent intent) {

    final ConnectivityManager connMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);        
    final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

    if (wifi.isAvailable()) || mobile.isAvailable()) {
          Log.d(TAG, "Network Available.");


    }
    else {          
        Log.d(TAG, "Network Unavailable");

    }        
  }
}