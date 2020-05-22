// Standalone class, declared in the manifest
public class ButtonReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        Intent intent = new Intent();
        intent.setAction("com.foo.ACTION");

        // Rebroadcasts to your own receiver. 
        // This receiver is not exported; it'll only be received if the receiver is currently registered.
        context.sendBroadcast(intent); 
    }
}