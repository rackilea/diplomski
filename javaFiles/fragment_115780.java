public void onPause(){
    super.onPause();
    if(null != mCamera){
        mCamera.release();
        mCamera = null;
    }
    frLyParent.removeView(mPreview);
    mPreview = null;
}