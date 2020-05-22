public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, acquire the camera and tell it where
        // to draw.
        try {
            Log.d(TAG, "surfaceCreated(), holder"+holder.toString());
            mCamera = null;
            mCamera = Camera.open();
            Log.d(TAG, "surfaceCreated(), mCamera="+mCamera);
            mCamera.setDisplayOrientation(90);
            mCamera.setPreviewDisplay(holder);
            Camera.Parameters params= mCamera.getParameters();
            params.set("jpeg-quality", 72);
            params.set("rotation", 90);
            params.set("orientation", "portrait");
            params.setPictureFormat(PixelFormat.JPEG);
                    mCamera.setParameters(params);
            createZoomlayout();

        } catch (Exception e) {
            Toast.makeText(CameraInterface.this,
                    " surfaceCreated " + e.getMessage(), Toast.LENGTH_LONG)
                    .show();
            e.printStackTrace();
        }
    }