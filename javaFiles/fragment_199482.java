public static Font myFont = getFont();

public static Font getFont() {
  try {
    FileInputStream fis = new FileInputStream("res/fonts/MYFONT.ttf");
    return Font.createFont(Font.TRUETYPE_FONT, fis);
  }
  // never catch "Exception", always catch the possible specific exceptions
  catch (IOException e) {
    System.err.println("Fonts failed to load.");
  }
  // fallback option
  return new Font("serif", Font.PLAIN, 24);
}