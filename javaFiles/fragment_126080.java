String backCameraId = null;
CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
for(String cameraId:manager.getCameraIdList()){
    CameraCharacteristics cameraCharacteristics = manager.getCameraCharacteristics(cameraId);
    Integer facing = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
    if(facing==CameraMetadata.LENS_FACING_BACK) {
        backCameraId = cameraId;
        break;
    }
}
Log.d(TAG, "back camera exists ? "+(backCameraId!=null));
Log.d(TAG, "back camera id  :"+backCameraId);