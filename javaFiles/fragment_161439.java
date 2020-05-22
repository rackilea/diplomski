import com.embocorp.utils.receipt.ocrreader.ui.camera.CameraSource;

public class OpticalProcessor {
    // TODO: Implement other interfaces here for receiveDetections method?

    private final Context mContext;
    private CameraSource.ShutterCallback shutterCallback;   
    private CameraSource.PictureCallback pictureCallback;
    private OnDetectionsReceievedListener detectionListener;

    public interface OnDetectionsReceievedListener {
        void onDetectionsReceived(Detector.Detections<TextBlock> detections);
    }

    public OpticalProcessor(Context c) {
        this(c, null, null);
    }

    public OpticalProcessor(Context c, CameraSource.ShutterCallback shutterCallback, CameraSource.PictureCallback pictureCallback) {
        this.mContext = c;
        setShutterCallback(shutterCallback);
        setPictureCallback(pictureCallback);
    }

    public void takePicture(CameraSource camera) {
        if (this.shutterCallback != null && this.pictureCallback != null) {
            camera.takePicture(this.shutterCallback, this.pictureCallback);
        } else {
            Log.w("OpticalProcessor::takePicture", "Shutter or Picture callbacks have not been set!");
        }
    }    

    public void setShutterCallback(CameraSource.ShutterCallback shutterCallback) {
        this.stutterCallback = shutterCallback;
    }

    public void setPictureCallback(CameraSource.PictureCallback pictureCallback) {
        this.pictureCallback = pictureCallback;
    }

    public void setDetectionListener(CameraSource.PictureCallback pictureCallback) {
        this.detectionListener = detectionCallback;
    }

    @Override
    public void receiveDetections(Detector.Detections<TextBlock> detections) {
        // Maybe this is needed? 
        if (detectionListener != null) {
            detectionListener.onDetectionsReceived(detections);
        }

        // Perform OCR Processing
        int tag = 0;
        if (tag > 3) { // Why would this have worked? It's set at 0...
            Log.d("Test", "Testing 1234454");
        }
    }
}