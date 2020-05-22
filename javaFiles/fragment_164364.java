protected static int widthOfText(String text, Font font, float fontSize, Graphics2D g2d) {
    font = font.deriveFont(fontSize);
    FontMetrics fm = g2d.getFontMetrics(font);
    int textWidth = fm.stringWidth(text);
    return textWidth;
}

public static Float pointToFit(double width, String text, Font font, Graphics2D g2d, float min, float max) {
    float fontSize = min + ((max - min) / 2f);
    font = font.deriveFont(fontSize);
    FontMetrics fm = g2d.getFontMetrics(font);
    int textWidth = fm.stringWidth(text);

    if (fontSize == min || fontSize == max) {
        return fontSize;
    }

    if (textWidth < width) {
        return pointToFit(width, text, font, g2d, fontSize, max);
    } else if (textWidth > width) {
        return pointToFit(width, text, font, g2d, min, fontSize);
    }
    return fontSize;
}