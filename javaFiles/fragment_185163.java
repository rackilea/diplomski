public class BootCompletedIntentReceiver extends BroadcastReceiver {
@Override
public void onReceive(Context context, Intent intent) {

    Intent i=new Intent(context, YourClass.class);

    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
        context.startForegroundService(i);
    }
    else {
        context.startService(i);
    }

}