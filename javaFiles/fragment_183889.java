if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null; // Usually back camera is at 0 position.
            try {
                cameraId = camManager.getCameraIdList()[0];
                camManager.setTorchMode(cameraId, false);  

 // TODO  Turn ON  Flash Light On
                mScannerView.setFlash(true);    
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }