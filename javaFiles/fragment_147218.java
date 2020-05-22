class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener{

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        scaleFactor *= detector.getScaleFactor();

        if(scaleFactor > 2) scaleFactor = 2;//Limit to your liking
        else if(scaleFactor < 0.3f) scaleFactor = 0.3f;//Limit to your liking
        scaleFactor = (scaleFactor * 100) / 100;//jitter-protection
        //scaleMatrix.setScale(scaleFactor, scaleFactor, detector.getFocusX(), detector.getFocusY());//This is for usage with a Matrix: Good for canvas and other areas where this is usable. This is from my own scaling code, so I keep the matrix around in this example in case it is needed
        tv.setScaleX(scaleFactor);
        tv.setScaleY(scaleFactor);
        tv.setPivotX(detector.getFocusX());
        tv.setPivotY(detector.getFocusY());
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {return true;}

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {}
}