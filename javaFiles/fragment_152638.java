private static Rectangle2D computeBoundsUsingNormalizedFont(
        String string, Graphics2D g) {
    Font normalizedFont = g.getFont().deriveFont(1f);
    Rectangle2D bounds = normalizedFont.getStringBounds(string, g.getFontRenderContext());

    float scale = g.getFont().getSize2D();
    return new Rectangle2D.Double(bounds.getX() * scale,
            bounds.getY() * scale,
            bounds.getWidth() * scale,
            bounds.getHeight() * scale);
}