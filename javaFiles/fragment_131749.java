public static boolean hasRetinaDisplay() {
  Object obj = Toolkit.getDefaultToolkit()
      .getDesktopProperty(
          "apple.awt.contentScaleFactor");
  if (obj instanceof Float) {
    Float f = (Float) obj;
    int scale = f.intValue();
    return (scale == 2); // 1 indicates a regular mac display.
  }
  return false;
}