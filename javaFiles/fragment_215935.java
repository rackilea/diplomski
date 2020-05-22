@Override public boolean onLongPress(final MotionEvent event, final MapView mapView) {
        boolean touched = hitTest(event, mapView);
        if (touched){
           //here, do whatever you want
           //....
        }
        return touched;
    }