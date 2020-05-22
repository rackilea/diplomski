public interface CameraFrame extends CvCameraViewFrame {
    Bitmap toBitmap();

    @Override
    Mat rgba();

    @Override
    Mat gray();
}