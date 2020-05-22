import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyFlashLight extends Activity implements Callback{

//flag to detect flash is on or off
private boolean isLighOn = false;

private Camera camera;

private Button button;

    @Override
protected void onStart() {
    super.onStart();

         SurfaceView preview = (SurfaceView)findViewById(R.id.PREVIEW);
                SurfaceHolder mHolder = preview.getHolder();
                mHolder.addCallback(this);
    }
}

@Override
protected void onStop() {
    super.onStop();

    if (camera != null) {
        camera.release();
    }
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    button = (Button) findViewById(R.id.buttonFlashlight);

    Context context = this;
    PackageManager pm = context.getPackageManager();

    // if device support camera?
    if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
        Log.e("err", "Device has no camera!");
        return;
    }

    camera = Camera.open();
    final Parameters p = camera.getParameters();

    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            if (isLighOn) {
                                turnOffFlash();
            } else {
                                turnOnFlash();
                          }
                     }
    });


            private void turnOnFlash(){
            Log.i("info", "torch is turn on!");

                p.setFlashMode(Parameters.FLASH_MODE_TORCH);

                camera.setParameters(p);
                camera.startPreview();
                isLighOn = true;

            }
            private void turnOffFlash(){
            Log.i("info", "torch is turn off!");

                p.setFlashMode(Parameters.FLASH_MODE_OFF);
                camera.setParameters(p);
                camera.stopPreview();
                isLighOn = false;
    @Override
    public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        mHolder = holder;
        try {
            Log.i("SurfaceHolder", "setting preview");
            camera.setPreviewDisplay(mHolder);  
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        Log.i("SurfaceHolder", "stopping preview");
        camera.stopPreview();
        mHolder = null;
    }

}