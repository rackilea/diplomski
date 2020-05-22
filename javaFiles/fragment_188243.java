// Assuming that Java will always produce valid UTF8 from a string, so no error checking!
// (Is this always true, I wonder?)
public class UTF8Cutter {
  public static String cut(String s, int n) {
    byte[] utf8 = s.getBytes();
    if (utf8.length < n) n = utf8.length;
    int n16 = 0;
    int advance = 1;
    int i = 0;
    while (i < n) {
      advance = 1;
      if ((utf8[i] & 0x80) == 0) i += 1;
      else if ((utf8[i] & 0xE0) == 0xC0) i += 2;
      else if ((utf8[i] & 0xF0) == 0xE0) i += 3;
      else { i += 4; advance = 2; }
      if (i <= n) n16 += advance;
    }
    return s.substring(0,n16);
  }
}