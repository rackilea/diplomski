@Override
public Mat onCameraFrame(Mat inputFrame)
{
    if (faceLocator != null) {
        bool face_detected = faceLocator.detectFaces(inputFrame);
        if (face_detected) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myTextElement.setTextColor(Color.GREEN);
                }
            });
        }
    }
    return inputFrame;
}