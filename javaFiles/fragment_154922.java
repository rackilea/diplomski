public class MyService extends Service {
public MyService() {
}

@Override
public IBinder onBind(Intent intent) {
    return Null;
}

@Override
public void onCreate() {
    Toast.makeText(this, "The new Service was Created", Toast.LENGTH_LONG).show();

}

@Override
public void onStart(Intent intent, int startId) {
    // For time consuming an long tasks you can launch a new thread here...
    // Do your Bluetooth Work Here
    Toast.makeText(this, " Service Started", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();

    }
}