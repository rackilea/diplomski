int pixVal = ... getRGB() as you have
int red = (pixVal >>> 16);
int green = (pixVal >>> 8) & 0xff;
int blue = pixVal & 0xff;
int brightness = (red + green + blue) / 3;
if (brightness < 16) {
  // pixel is black
}