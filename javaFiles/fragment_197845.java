public class CustomFontResource {
    public static FontUIResource createFont(String path, final int size) {
        Font font = Font.createFont(Font.TRUETYPE_FONT,
                new FileInputStream(path));

        FontUIResource fontResource = new FontUIResource(font.deriveFont(
            Font.PLAIN, size));
        return fontResource;
    }

}