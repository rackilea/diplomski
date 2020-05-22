@Override
protected void onPause() {
    try {
        if (!needOnPause) {
            super.onPause();
        }

        else {
            super.onPause();
            Toast.makeText(LightsOn.this, "Flashlight off..!!",Toast.LENGTH_SHORT).show();
            button.setBackgroundResource(R.drawable.onswitch);
            myparas.setFlashMode(Parameters.FLASH_MODE_OFF);
            mycamera.setParameters(myparas);
            mycamera.stopPreview();
            flashon = false;
            mycamera.release();
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}