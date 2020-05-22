public class FontLoader {

    public static Font loadFont(float size, int style, JLabel j) {
    Font font = null;
    InputStream is = j.getClass().getResourceAsStream("starv___.ttf");
    try {
        font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(size);
        font = font.deriveFont(style);
    } /*catch (FileNotFoundException fe) {
        System.out.println("File not found"); // was in here because i tried a file       instead of an InputStream
    } */catch (FontFormatException ex) {
        System.out.println("Font is null1");
    } catch (IOException e) {
        System.out.println("Font is null2");
    }
    return font;
}
}