public class SimpleReceiver extends WakefulBroadcastReceiver{

@Override
public void onReceive(Context context, Intent intent) {

        //run below code if you need, depends on your saved value of Checkbox in SharedPreferences
        Intent serviceIntent = new Intent(context, YourService.class);
        context.startService(serviceIntent);
    }
}