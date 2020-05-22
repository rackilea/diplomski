public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BroadcastReceiver mNetworkReceiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerNetworkBroadcastForNougat();

    }

private void registerNetworkBroadcastForNougat() {
    mNetworkReceiver = new NetworkChangeReceiver();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
}

protected void unregisterNetworkChanges() {
    try {
        unregisterReceiver(mNetworkReceiver);
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    }
}

@Override
public void onDestroy() {
    super.onDestroy();
    unregisterNetworkChanges();
}



class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        try
        {
            if (!isOnline(context)) {
                showDialog(context);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void showDialog(final Context context) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("You must have internet connection");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder1.create();
        builder1.show();
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}