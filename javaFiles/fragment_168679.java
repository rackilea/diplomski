public class NetworkChangeReceiver extends BroadcastReceiver {

    // Static Listener, you can change this
    static OnNetworkConnectionChangedListener mListener;

    // Service to check if Wifi is connected or not
    ConnectivityManager mConnectivityManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(mListener != null) {
            if(mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            }
            mListener.onConnectionChanged(NetworkStatusHelper.getConnectivityStatus(mConnectivityManager) != NetworkStatusHelper.TYPE_NOT_CONNECTED);
        }
    }

    public static boolean isConnected(Context context) {
        return NetworkStatusHelper.getConnectivityStatus((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) != NetworkStatusHelper.TYPE_NOT_CONNECTED;
    }

    public static void setOnNetworkConnectionChangedListener(OnNetworkConnectionChangedListener listener) {
        mListener = listener;
    }

    public interface OnNetworkConnectionChangedListener {
        public void onConnectionChanged(boolean connected);
    }
}