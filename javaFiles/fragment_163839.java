public class MyService extends Service {
private static boolean isRunning = false;
private Context context;

@Override
public void onCreate() {
    super.onCreate();
    context = this;
}

public static boolean isServiceRunning() {
    return isRunning;
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    if(!isRunning) {
      isRunning = true;

    }
    return START_STICKY;
}