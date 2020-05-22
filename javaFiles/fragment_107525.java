try {
    // Change some capture settings
    mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON);
    // Build new request (we can't just edit existing one, as it is immutable)
    mPreviewRequest = mPreviewRequestBuilder.build();
    // Set new repeating request with our changed one
    mCaptureSession.setRepeatingRequest(mPreviewRequest, mCaptureCallback, mBackgroundHandler);
} catch (CameraAccessException e) {
    e.printStackTrace();
}