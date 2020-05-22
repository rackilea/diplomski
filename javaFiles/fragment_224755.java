public void setRadius(float cornerRadius) {
    CORNER_RADIUS = cornerRadius;

    // Now you need to calculate the field *cornerRadius* once more
    //
    DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
    cornerRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, CORNER_RADIUS, metrics);

    invalidate();
}