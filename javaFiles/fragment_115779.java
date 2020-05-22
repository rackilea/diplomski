public void onResume{
    super.onResume();
    mCamera = Camera.open();
    if(null != mCamera){
        mCamera.setDisplayOrientation(90);
        mPreview = new CameraOverlay(getActivity(), mCamera);
        frLyParent.addView(mPreview);
    }
}