public class MyService extends Service
{

private static final String TAG = "MyService";


@Override
public void onStart(Intent intent, int startId)
{
    // TODO Auto-generated method stub
    super.onStart(intent, startId);
}

@Override
public boolean onUnbind(Intent intent) {
    return super.onUnbind(intent);
}


@Override
public void onCreate()
{
    super.onCreate();
}

@Override
public int onStartCommand(Intent intent, int flags, int startId)
{
    //call to onTaskRemoved
    onTaskRemoved(intent);
    //return super.onStartCommand(intent, flags, startId);
    Toast.makeText(this, "Service Started!", Toast.LENGTH_SHORT).show();

    return START_NOT_STICKY;
}

@Nullable
@Override
public IBinder onBind(Intent intent)
{
    return null;
}

@Override
public void onDestroy()
{
    Toast.makeText(this, "Service Destroyed!", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent("com.myapp.startservice");
    //Intent intent = new Intent("android.intent.action.BOOT_COMPLETED");
    intent.putExtra("yourvalue", "torestore");
    sendBroadcast(intent);
    super.onDestroy();

}



@Override public void onTaskRemoved(Intent rootIntent)
{
    Log.e("onTaskRemoved", "Called!");

    //thread = new Thread(this);
    //startThread();

    /*Intent alarm = new Intent(this.getApplicationContext(), MyBroadCastReceiver.class);
    boolean alarmRunning = (PendingIntent.getBroadcast(this.getApplicationContext(), 0, alarm, PendingIntent.FLAG_NO_CREATE) != null);
    //if(!alarmRunning)
    {
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, alarm, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 10000, pendingIntent);
        }
    }*/

     //send broadcast to your BroadcastReciever
    Intent intent = new Intent("com.myapp.startservice"); //unique String to uniquely identify your broadcastreceiver
    //Intent intent = new Intent("android.intent.action.BOOT_COMPLETED");
    intent.putExtra("yourvalue", "torestore");
    sendBroadcast(intent);

     //intent to restart your service.
    Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());
    restartServiceIntent.setPackage(getPackageName());

    PendingIntent restartServicePendingIntent = PendingIntent.getService(getApplicationContext(), 1, restartServiceIntent, PendingIntent.FLAG_ONE_SHOT);
    AlarmManager alarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
    if (alarmService != null) {
        alarmService.set(
                AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 1000,
                restartServicePendingIntent);
    }

    super.onTaskRemoved(rootIntent);

}}