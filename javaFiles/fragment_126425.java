import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;


public class PictureService extends Service
{
    private static final String TAG = PictureService.class.getSimpleName();

    private TakePhotoReceiver mReceiver;



    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d(TAG, "onCreate");
        mReceiver = new TakePhotoReceiver(0);
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_SCREEN_ON));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        unregisterReceiver(mReceiver);
    }


    private final class TakePhotoReceiver extends BroadcastReceiver
        implements Camera.PictureCallback
    {
        public final int mCameraId;


        private TakePhotoReceiver(int cameraId)
        {
            mCameraId = cameraId;
        }

        @Override
        public void onReceive(Context context, Intent intent)
        {
            try{
                Camera camera = Camera.open(mCameraId);
                try{
                    Log.d(TAG, "onReceive: Taking picture");
                    camera.takePicture(null, null, this);
                }
                finally{
                    camera.release();
                    camera = null;
                }
            }
            catch(Exception e){
                Log.w(TAG, "onReceive: error with camera " + mCameraId, e);
            }
        }

        @Override
        public void onPictureTaken(byte[] data, Camera camera)
        {
            Log.d(TAG, "onPictureTaken");
            File picturesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            savePictureTo(picturesDir, data);
        }
    }

    private void savePictureTo(File directory, byte[] data)
    {
        String fileName = new SimpleDateFormat("'JPEG_'yyyyMMdd_HHmmss'.jpg'")
            .format(System.currentTimeMillis());
        File file = new File(directory, fileName);
        try{
            directory.mkdirs();
            OutputStream os = new FileOutputStream(file);
            os.write(data);
            os.close();

            MediaScannerConnection.scanFile(this, new String[ ] { file.toString() }, 
                null, new MediaScannerConnection.OnScanCompletedListener()
            {
                @Override
                public void onScanCompleted(String path, Uri uri)
                {
                    Log.d(TAG, "savePictureTo: scanned path=" + path + ", uri=" + uri);
                }
            });
        }
        catch(IOException e){
            Log.w(TAG, "savePictureTo: error writing " + file, e);
        }
    }
}