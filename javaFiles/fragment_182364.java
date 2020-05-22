public Font scaleFont(String text, Rectangle rect, Graphics g, Font pFont) {
    float fontSize = 20.0f;
    Font font = pFont;

    font = g.getFont().deriveFont(fontSize);
    int width = g.getFontMetrics(font).stringWidth(text);
    fontSize = (rect.width / width ) * fontSize;
    return g.getFont().deriveFont(fontSize);
}