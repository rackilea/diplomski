private class ScaleListener extends
        ScaleGestureDetector.SimpleOnScaleGestureListener {

    @Override
    public boolean onScale(ScaleGestureDetector detector) {

        float value = detector.getScaleFactor();
        currentScaleFactor = currentScaleFactor * value;

        // don't let the object get too small or too large.
        boolean doesntMatch = false;
        if (currentScaleFactor < 1f || currentScaleFactor > 20f){
            currentScaleFactor = Math.max(1f, Math.min(currentScaleFactor, 20f));
            doesntMatch = true;
        }

        if(!doesntMatch){
            //scale the viewport as well
            currentPan.x = currentPan.x*value;
            currentPan.y = currentPan.y*value;

        }
        return true;
    }
}