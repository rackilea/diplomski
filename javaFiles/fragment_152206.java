SurfaceHolder.Callback surfaceCallback=new SurfaceHolder.Callback() {
    public void surfaceCreated(SurfaceHolder holder) {
        // no-op -- wait until surfaceChanged()

    }
    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width,
                               int height) {
        Camera.Parameters parameters=camera.getParameters();
        Camera.Size size=getBestPreviewSize(width, height,
                    parameters);
        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

        if (size!=null) {
            parameters.setPreviewSize(size.width, size.height);
            camera.setParameters(parameters);
            camera.setDisplayOrientation(90);
            cameraConfigured=true;
        }
        camera.startPreview();
    }
    public void surfaceDestroyed(SurfaceHolder holder) {
        // no-op
    }
};