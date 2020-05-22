public class CameraView extends Activity implements SurfaceHolder.Callback {

android.hardware.Camera mCamera;
boolean mPreviewRunning = false;

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    getWindow().setFormat(PixelFormat.TRANSLUCENT);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.camera_surface);
    SurfaceView mSurfaceView = (SurfaceView)findViewById(R.id.surface_camera);
    SurfaceHolder mSurfaceHolder = mSurfaceView.getHolder();
    mSurfaceHolder.addCallback(this);
    mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
}


@Override
public void surfaceCreated(SurfaceHolder holder) {
try {
        mCamera.setPreviewDisplay(previewHolder);   
    }
    catch (Throwable t) {
        Log.e(TAG, "Exception in setPreviewDisplay()", t);
    }
}


@Override
 public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    Camera.Parameters parameters=camera.getParameters();
    Camera.Size size=getBestPreviewSize(width, height, parameters);

    if (size!=null) {
        parameters.setPreviewSize(size.width, size.height);
        camera.setParameters(parameters);
        camera.startPreview();
        inPreview=true;
    }
  }

@Override
public void surfaceDestroyed(SurfaceHolder holder) {
    mCamera.stopPreview();
    mPreviewRunning = false;
    mCamera.release();
}

android.hardware.Camera.PictureCallback mPictureCallback = new android.hardware.Camera.PictureCallback() {

    @Override
    public void onPictureTaken(byte[] data, android.hardware.Camera camera) {

    }
};

    private Camera.Size getBestPreviewSize(int width, int height, Camera.Parameters parameters) {
    Camera.Size result=null;

    for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
        if (size.width<=width && size.height<=height) {
            if (result==null) {
                result=size;
            }
            else {
                int resultArea=result.width*result.height;
                int newArea=size.width*size.height;

                if (newArea>resultArea) {
                    result=size;
                }
            }
        }
    }

    return(result);
}
}