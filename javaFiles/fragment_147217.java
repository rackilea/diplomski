class Scaler extends ScaleGestureDetector {
    public Scaler(Context context, OnScaleGestureListener listener) {
        super(context, listener);
    }

    @Override
    public float getScaleFactor() {//Leave this method empty.
        return super.getScaleFactor();
    }
}