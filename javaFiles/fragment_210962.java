public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
         if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
              //Do your coding here...
         }
    }
}