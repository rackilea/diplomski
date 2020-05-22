import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by muthukrishnan on 10/06/17.
 */

public class PersistService extends Service {

    private static final int INTERVAL = 3000; // poll every 3 secs
    private static final String YOUR_APP_PACKAGE_NAME = "YOUR_APP_PACKAGE_NAME";

    private static boolean stopTask;
    private PowerManager.WakeLock mWakeLock;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        stopTask = false;

        // Optional: Screen Always On Mode!
        // Screen will never switch off this way
        mWakeLock = null;

        // NOTE : @Muthu I am not sure what is this variable called settings
        if (settings.pmode_scrn_on){
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "a_tag");
            mWakeLock.acquire();
        }

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        // Start your (polling) task
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // If you wish to stop the task/polling
                if (stopTask){
                    this.cancel();
                }


                // The first in the list of RunningTasks is always the foreground task.
                ActivityManager.RunningTaskInfo foregroundTaskInfo = activityManager.getRunningTasks(1).get(0);
                String foregroundTaskPackageName = foregroundTaskInfo .topActivity.getPackageName();

                // Check foreground app: If it is not in the foreground... bring it!
                if (!foregroundTaskPackageName.equals(YOUR_APP_PACKAGE_NAME)){
                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(YOUR_APP_PACKAGE_NAME);
                    startActivity(LaunchIntent);
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, INTERVAL);
    }

    @Override
    public void onDestroy(){
        stopTask = true;
        if (mWakeLock != null)
            mWakeLock.release();
        super.onDestroy();
    }
}