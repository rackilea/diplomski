public void setCameraDisplayOrientation(android.hardware.Camera camera) {
            Camera.Parameters parameters = camera.getParameters();

            android.hardware.Camera.CameraInfo camInfo =
                    new android.hardware.Camera.CameraInfo();
            android.hardware.Camera.getCameraInfo(getBackFacingCameraId(), camInfo);


            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            int rotation = display.getRotation();
            int degrees = 0;
            switch (rotation) {
                case Surface.ROTATION_0:
                    degrees = 0;
                    break;
                case Surface.ROTATION_90:
                    degrees = 90;
                    break;
                case Surface.ROTATION_180:
                    degrees = 180;
                    break;
                case Surface.ROTATION_270:
                    degrees = 270;
                    break;
            }

            int result;
            if (camInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                result = (camInfo.orientation + degrees) % 360;
                result = (360 - result) % 360;  // compensate the mirror
            } else {  // back-facing
                result = (camInfo.orientation - degrees + 360) % 360;
            }
            camera.setDisplayOrientation(result);
        }