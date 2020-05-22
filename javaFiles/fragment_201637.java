private org.opencv.core.Rect mBoundingRect;

@Override
public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
    // input frame has RGBA format
    mRgba = inputFrame.rgba();
    mGray = inputFrame.gray();
    mBoundingRect = doWithMat(mGray.getNativeObjAddr(), mRgba.getNativeObjAddr());
    return mRgba;
}