CameraManager cameraManager = (CameraManager)getSystemService(CAMERA_SERVICE);
    try {
        if (hasFlashForFrontCamera(cameraManager)) {
            // has flash for front camera
        }

    } catch (CameraAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

boolean hasFlashForFrontCamera(CameraManager cManager) throws CameraAccessException {
    for(final String cameraId : cManager.getCameraIdList()){
        CameraCharacteristics characteristics = cManager.getCameraCharacteristics(cameraId);
        int cOrientation = characteristics.get(CameraCharacteristics.LENS_FACING);
        if(cOrientation == CameraCharacteristics.LENS_FACING_FRONT) {
            return characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        }
    }
    return false;
}