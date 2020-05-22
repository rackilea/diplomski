public void onResume() {
    super.onResume();
    for(int i=0;i<Camera.getNumberOfCameras();i++){
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(i,info);
        if(info.facing== Camera.CameraInfo.CAMERA_FACING_FRONT){
            cameraId = i;
            break;
        }
    }
    camera=Camera.open(cameraId);
    camera.startPreview();
}