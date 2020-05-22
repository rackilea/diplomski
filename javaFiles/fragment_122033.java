@TargetApi(Build.VERSION_CODES.M)
private void turnOnFlash() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            imageFlashlight.setImageResource(R.drawable.poweron);
        } catch (CameraAccessException e) {
        }
    } else {


        imageFlashlight.setImageResource(R.drawable.poweron);

        getCamera();
        params = camera.getParameters();
        params = camera.getParameters();
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();

    }
       isFlashOn = true;
       flashLightStatus = true;
}