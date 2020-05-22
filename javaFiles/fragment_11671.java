int numCameras= Camera.getNumberOfCameras();
for(int i=0;i<numCameras;i++){
    Camera.CameraInfo info = new CameraInfo();
    Camera.getCameraInfo(i, info);
    if(CAMERA_FACING_FRONT == info.facing){
        return true;
    }
}
return false;