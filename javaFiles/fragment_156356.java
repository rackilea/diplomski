private float calculateDP(float px){        
  return px / (densityDpi / densityDefault);
}

private float pixelsPerMeter(float value){
    float w = plot.getGraph().getWidgetDimensions().canvasRect.width();
    float w2 = plot.getBounds().getWidth().floatValue();
    return value * (w / w2);
}

private void init(Activity activity){
    densityDpi = activity.getResources().getDisplayMetrics().densityDpi;
    densityDefault = android.util.DisplayMetrics.DENSITY_DEFAULT;
}

private void onCreate(){
// ... lots of stuff
labelFormatter.getVertexPaint().setStrokeWidth(calculateDP(pixelsPerMeter(2)));
}