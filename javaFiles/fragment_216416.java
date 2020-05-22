public static double spaceWidth(Font font, String text) {
    FontRenderContext frc = new FontRenderContext(font.getTransform(), true, true);
    Rectangle2D textRect = font.getStringBounds(text, frc);
    Rectangle2D spaceRect = font.getStringBounds(" ", frc);
    return textRect.getWidth() / spaceRect.getWidth();
}  

public static void main(String[] args) {
    Font font = new Font("Monospaced", Font.PLAIN, 10);
    System.out.println("Font: " + font.getFamily());

    String s = "안녕abc";
    //         "      " (6 spaces)
    System.out.printf("'%s' -> %f%n", s, spaceWidth(font, s));
}