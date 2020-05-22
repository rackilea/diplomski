// Add a listener to the Capture button
Button captureButton = (Button) findViewById(R.id.button_capture);

captureButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Camera mCamera = getCameraInstance();
        // get an image from the camera
        mCamera.takePicture(null, null, mPicture);
    }
}
);