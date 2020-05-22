CameraErrorCallback errorCallback = new CameraErrorCallback();
@SuppressWarnings("deprecation")
public class CameraErrorCallback implements android.hardware.Camera.ErrorCallback {
    @Override
    public void onError(int error, android.hardware.Camera camera) {
    // Do something.
    }
}