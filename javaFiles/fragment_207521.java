public int enlight(int color, float amount) {
  float[] hsv = new float[3];
  Color.colorToHSV(color, hsv);
  hsv[2] = Math.min(1.0f, amount * hsv[2]);
  return Color.HSVToColor(hsv);
}