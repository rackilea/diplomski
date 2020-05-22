public class NetworkChangeReceiver extends BroadcastReceiver {

    ConnectionChangeCallback connectionChangeCallback;

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();


        if (connectionChangeCallback != null) {
            connectionChangeCallback.onConnectionChange(isConnected);
        }

    }

    public void setConnectionChangeCallback(ConnectionChangeCallback
                                                    connectionChangeCallback) {
        this.connectionChangeCallback = connectionChangeCallback;
    }


    public interface ConnectionChangeCallback {

        void onConnectionChange(boolean isConnected);

    }


}