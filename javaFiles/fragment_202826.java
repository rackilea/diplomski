public class MainActivity extends Activity
{
    private GpsStatusReceiver receiver = new GpsStatusReceiver();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION));
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(receiver);
    }

    private class GpsStatusReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            LocationManager lm = (LocationManager) context.getSystemService(Service.LOCATION_SERVICE);
            boolean isEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            onGpsStatusChanged(isEnabled);
        }
    }

    private void onGpsStatusChanged(boolean isEnabled)
    {
        // Do/start your work here.
        Toast.makeText(this, "GPS enabled - " + isEnabled, 0).show();
    }
}