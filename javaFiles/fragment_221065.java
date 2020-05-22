public int getRotation() {
    int orientation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();

    switch (orientation) {
        case Surface.ROTATION_90:  return 90;
        case Surface.ROTATION_180: return 180;
        case Surface.ROTATION_270: return 270;
        default: return 0;
    }
}