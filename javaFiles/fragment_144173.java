static BufferedImage textToImage(String text) {
    return textToImage(text, java.awt.Font.decode(null), 13);
}

static BufferedImage textToImage(String Text, Font font, float size) {
    font = font.deriveFont(size);

    FontRenderContext frc = new FontRenderContext(null, true, true);

    LineMetrics lm = font.getLineMetrics(Text, frc);
    Rectangle2D r2d = font.getStringBounds(Text, frc);
    BufferedImage img = new BufferedImage((int) Math.ceil(r2d.getWidth()), (int) Math.ceil(r2d.getHeight()), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = img.createGraphics();
    g2d.setRenderingHints(RenderingProperties);
    g2d.setBackground(new Color(0, 0, 0, 0));
    g2d.setColor(Color.BLACK);

    g2d.clearRect(0, 0, img.getWidth(), img.getHeight());
    g2d.setFont(font);
    g2d.drawString(Text, 0, lm.getAscent());
    g2d.dispose();

    return img;
}