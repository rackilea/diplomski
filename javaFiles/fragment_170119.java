public class StopServiceReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 333;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, ServiceYouWantStopped.class);
        context.stopService(service);
    }
}