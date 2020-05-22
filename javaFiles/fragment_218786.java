public String getExternalCamera(){

        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        String exCamId = null;

        for (String cameraId : cameraManager.getCameraIdList()) {
                    CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
                    Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);

                    //LENS_FACING_EXTERNAL will return Value: 2
                    if (facing != null && facing.equals(CameraCharacteristics.LENS_FACING_EXTERNAL)) {
                        exCamId = cameraId;
                    }
                }

                return exCamId;

        }