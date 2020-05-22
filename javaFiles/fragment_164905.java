import android.app.Service;
import android.content.Intent;
import android.os.FileObserver;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import java.io.File;

public class MediaListenerService extends Service {

    public static FileObserver observer;

    public MediaListenerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startWatching();
    }

    private void startWatching() {
        final String pathToWatch = android.os.Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera/";
        Toast.makeText(this, "My Service Started and trying to watch " + pathToWatch, Toast.LENGTH_LONG).show();

        observer = new FileObserver(pathToWatch, FileObserver.CLOSE_WRITE) { // set up a file observer to watch this directory on sd card
            @Override
            public void onEvent(int event, final String file) {
                if (!file.equals(".probe")) { // check that it's not equal to .probe because thats created every time camera is launched
                    Log.d("MediaListenerService", "File created [" + pathToWatch + file + "]");

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), file + " was saved!", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        };
        observer.startWatching();
    }
}