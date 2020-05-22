import com.embocorp.utils.receipt.ocrreader.ui.camera.CameraSource;

public class OcrCaptureActivity extends Activity 
    implements CameraSource.ShutterCallback, CameraSource.PictureCallback, 
     OpticalProcessor.OnDetectionsReceievedListener {

    private CameraSource mCameraSource;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        // setContentLayout...

        ...

        mCameraSource = ???

        // Pass the context and the listeners here
        final OpticalProcessor processor = new OpticalProcessor(this, this, this);
        processor.setDetectionListener(this); 

        someButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                processor.takePicture(mCameraSource);
            }
        });
    }

    // This method could really be anywhere as long as it has a Context
    public static String saveToInternalStorage(Context ctx, Bitmap bitmapImage, String name) {
        File directory = ctx.getDir("imageDir", Context.MODE_PRIVATE);
        File path=new File(directory, name + ".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               fos.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

        return directory.getAbsolutePath();
    }

    @Override
    public void onShutter() {
        Log.d("New", "New");
    }

    @Override
    public void onPictureTaken(byte[] data) {
        Log.d("Move", "mobe");
        Bitmap bmp=BitmapFactory.decodeByteArray(data, 0, data.length);
        saveToInternalStorage(this, bmp, getCurrentTimeStamp());

        // Activity started here
        startActivity(new Intent(this, ReportActivity.class));
    }

    @Override
    public void onDetectionsReceived(Detector.Detections<TextBlock> detections) {
        // Perform OCR Processing??
    }
}