if (cameraCharacteristics != null && cameraCharacteristics.get(CameraCharacteristics.LENS_FACING) != null) {
            Integer lensFaceingCameraCharacteristics = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);

            if (lensFaceingCameraCharacteristics != null 
                 && cameraFacing == lensFaceingCameraCharacteristics) {
                StreamConfigurationMap streamConfigurationMap = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                previewSize = getPreviewSize(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), width, height);
                this.cameraId = cameraId;
            }
        }