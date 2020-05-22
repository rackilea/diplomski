//camera = Camera.open();
//final Parameters p = camera.getParameters();

button.setOnClickListener(new OnClickListener() {
    public void onClick(View arg0) {
        if (isFlashOn) {
           Log.i("info", "torch is turned off!");                   
           cam.stopPreview();
           cam.release();
           isFlashOn = false;
           button.setText("Tap to turn flashlight on.");
           } 
        else {
           Log.i("info", "torch is turned on!");
           camera = Camera.open();
           Parameters p = camera.getParameters();
           p.setFlashMode(Parameters.FLASH_MODE_OFF);
           camera.setParameters(p);
           camera.startPreview();
           p.setFlashMode(Parameters.FLASH_MODE_TORCH);
           camera.setParameters(p);
           isFlashOn = true;
           button.setText("Tap to turn flashlight off.");
        }
    }
});