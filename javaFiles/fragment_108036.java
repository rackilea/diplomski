Camera.PictureCallback pictureCallBack = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, final Camera camera) {

            Matrix matrix = new Matrix();

            //if (bitmap.getWidth() > bitmap.getHeight()) {
            if (facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                matrix.postRotate(90);
            } else {
                Matrix matrixMirrory = new Matrix();
                float[] mirrory = {-1, 0, 0, 0, 1, 0, 0, 0, 1};
                matrixMirrory.setValues(mirrory);
                matrix.postConcat(matrixMirrory);
                matrix.postRotate(90);
            }
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        }
    }