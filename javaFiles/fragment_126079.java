int backCameraId = -1;
for(int i=0;i<Camera.getNumberOfCameras();i++){
    CameraInfo cameraInfo = new CameraInfo();
    Camera.getCameraInfo(i,cameraInfo);
    if(cameraInfo.facing==CameraInfo.CAMERA_FACING_BACK) {
        backCameraId = i;
        break;
    }
}
Log.d(TAG, "back camera exists ? "+(backCameraId>-1));
Log.d(TAG, "back camera id  :"+backCameraId);