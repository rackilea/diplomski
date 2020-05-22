public void onPause() {
    super.onPause();

    if (mCamera != null) {
        mCamera.setPreviewCallback(null);
        mPreview.getHolder().removeCallback(mPreview);   // you need this line
        mCamera.release();
    }
}