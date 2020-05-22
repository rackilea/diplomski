private void BlinkFlash(){
    String myString = "010101010101";
    long blinkDelay =50; //Delay in ms
    for (int i = 0; i < myString.length(); i++) {
        if (myString.charAt(i) == '0') {
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;



        } else {
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;

        }
        try {
            Thread.sleep(blinkDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}