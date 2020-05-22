boolean isFlashlightOn = false;
boolean deviceHasCameraFlash = getPackageManager().hasSystemFeature(
                                 PackageManager.FEATURE_CAMERA_FLASH);

if(deviceHasCameraFlash) {
  Camera camera = Camera.open();
  Camera.Parameters parameters = camera.getParameters();

  if(isFlashlightOn) { 
    // turn the flashlight off
    parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
    camera.setParameters(parameters);
    camera.stopPreview();
    isFlashlightOn = false;
  } else {
    // turn the flashlight on
    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
    camera.setParameters(parameters);
    camera.startPreview();
    isFlashlightOn = true;
  }
}