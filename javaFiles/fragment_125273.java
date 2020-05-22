protected void processFrame(VideoCapture capture) {
    capture.retrieve(mRgba, Highgui.CV_CAP_ANDROID_COLOR_FRAME_RGBA);
    Mat rgb;
    Imgproc.cvtColor(mRgba, rgb, Imgproc.COLOR_RGBA2RGB);
    mBGSub.apply(rgb, mFGMask);
}