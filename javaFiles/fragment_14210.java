@Override
    public void onPictureTaken(byte[] picture) {
        super.onPictureTaken(picture);
        CameraUtils.decodeBitmap(picture, new CameraUtils.BitmapCallback() {
            @Override
            public void onBitmapReady(Bitmap bitmap) {
                //Here comes your bitmap
            }
        });
    }