int[] rgbVals = new int[4];

protected int correctGamma(int pixel, float gamma) {
    float ginv = 1 / gamma;
    ColorUtils.unpackInt(pixel, ColorUtils.TYPE_ARGB, rgbVals);
    for(int i = 0; i &lt; rgbVals.length; i++) {
        rgbVals[i] = (int) Math.round(255 - Math.pow(rgbVals[i] / 255.0, ginv));
    }
    return ColorUtils.packInt(rgbVals);
}