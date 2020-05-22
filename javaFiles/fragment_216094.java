mImage.post(new Runnable() {
    @Override
    public void run() {
        mImage.setImageBitmap(loadBitmapFromView(mImage));
    }
});