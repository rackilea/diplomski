public class UpdatingReceiver extends BroadcastReceiver {
@Override
public void onReceive(Context context, Intent intent) {
    if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()) || Intent.ACTION_PACKAGE_REPLACED.equals(intent.getAction())) {
        // check is need to show notification
    }
}