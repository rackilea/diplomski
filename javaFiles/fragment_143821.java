@Override
public void onFinish() {
    if (mMediaProjection == null && !isServiceRunning(RecorderService.class)) {
        //Request Screen recording permission
        startActivityForResult(mProjectionManager.createScreenCaptureIntent(), ConstKeys.SCREEN_RECORD_REQUEST_CODE);
        Log.e("RecordingLog","OnFinished");
    } else if (isServiceRunning(RecorderService.class)) {
        //stop recording if the service is already active and recording
    }
    finish(); // what does this method do?
}