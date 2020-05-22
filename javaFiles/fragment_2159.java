@Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(camera != null) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size size = getBestPreviewSize(width, height, parameters);
        if (size != null) {
            parameters.setPreviewSize(size.width, size.height);
            Log.d(TAG, "Using width=" + size.width + " height=" + size.height);
        }
        camera.setParameters(parameters);
        camera.startPreview();
        inPreview = true;
        }
    }