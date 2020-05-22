public class Poller extends BroadcastReceiver {
    private final String TAG = "Poller";
    @Override
    public void onReceive( Context context, Intent intent ) {
    Log.i(TAG, "Poller broadcastintent received");
    Intent myIntent = new Intent( context, PollerService.class );
    context.startService( myIntent );
}