public class CheckRunningActivity extends Service {
private static final String TAG = "CheckRunningActivity";
boolean checkApps;
private Timer mTimer = null;
private Handler mHandler = new Handler();
private ActivityManager am;

public static final long NOTIFY_INTERVAL = 1000; // 1 second

    @Override
    public void onDestroy() {
        mTimer.cancel();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

@Override
public void onCreate() {
    Log.d(TAG, "I created it");   


     // cancel if already existed
    if(mTimer != null) {
        mTimer.cancel();
    } else {
        // recreate new
        mTimer = new Timer();
    }
    // schedule task
    mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
}



class TimeDisplayTimerTask extends TimerTask {

    @Override
    public void run() {

        // run on another thread
        mHandler.post(new Runnable() {

            @Override
            public void run() {
                ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
                Log.d(TAG, "Its running");   

        String packageName = am.getRunningTasks(1).get(0).topActivity.getPackageName();

            Toast.makeText(getBaseContext(), packageName, Toast.LENGTH_LONG).show();
            Log.d(TAG, "Make Toast");           
            }
        });
     }
 }          
}