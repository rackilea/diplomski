char convert32Colorto16(Color color) {
  byte a,r,g,b;
  r = color.getRed() >> 3;
  g = color.getGreen() >> 3;
  b = color.getBlue() >> 3;
  a = color.getAlpha() >> 7;
  return (a << 15) | (b << 10) | (g << 5) | (r);
}