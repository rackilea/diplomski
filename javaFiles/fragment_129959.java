public class YourActivity implments NetworkChangeReceiver.ConnectionChangeCallback
{
@Override
    protected void onCreate(Bundle savedInstanceState) {
        .....
        IntentFilter intentFilter = new 
        IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");

        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();

        registerReceiver(networkChangeReceiver, intentFilter);

        networkChangeReceiver.setConnectionChangeCallback(this);

    }

    @Override
    public void onConnectionChange(boolean isConnected) {
    if(isConnected){
    // will be called when internet is back
    }
    else{
    // will be called when internet is gone.
    }

    }
}