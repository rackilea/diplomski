public class App_killed extends Service {

@Override
public IBinder onBind(Intent intent) {
    return null;
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d("ClearFromRecentService", "Service Started");
    return START_STICKY;
}

@Override
public void onDestroy() {
    super.onDestroy();
    Log.d("ClearFromRecentService", "Service Destroyed");
}

public void onTaskRemoved(Intent rootIntent) {
    Log.e("ClearFromRecentService", "END");
    //here you can call a background network request to post you location to server when app is killed
    Toast.makeText(getApplicationContext(), "Warning: App killed", Toast.LENGTH_LONG).show();
    stopSelf(); //call this method to stop the service
}
}