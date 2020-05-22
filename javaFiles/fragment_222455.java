import java.awt.Color;

abstract class EightBit {
  public static int fromColor(Color c) {
    return ((c.getAlpha() >> 6) << 6)
         + ((c.getRed()   >> 6) << 4)
         + ((c.getGreen() >> 6) << 2)
         +  (c.getBlue()  >> 6);
  }
  public static Color toColor(int i) {
    return new Color(((i >> 4) % 4) * 64,
                     ((i >> 2) % 4) * 64,
                      (i       % 4) * 64,
                      (i >> 6)      * 64);
  }
}