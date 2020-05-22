Graphics2D graphics = image.createGraphics();
graphics.setColor(Color.black);

if (subtitleFont == null) {
    //create rectangle first (from a separate library
    int[] rect = matrix.getEnclosingRectangle();
    // define the maximum rect for the text
    Rectangle2D maxRect = new Rectangle2D.Float(0, 0, w - 7, h - rect[0] - rect[3] - 10);

    subtitleX = 0;
    subtitleY = 0;
    // starting with a very big font due to a high res image
    float size = 80f * 4f;
    // starting with a diff half the size of the font
    float diff = size / 2;
    subtitleFont = graphics.getFont().deriveFont(Font.BOLD).deriveFont(size);
    FontMetrics fontMetrics = graphics.getFontMetrics(subtitleFont);
    Rectangle2D stringBounds = null;

    while (Math.abs(diff) > 1) {
        subtitleFont = subtitleFont.deriveFont(size);
        graphics.setFont(subtitleFont);
        fontMetrics = graphics.getFontMetrics(subtitleFont);
        stringBounds = fontMetrics.getStringBounds(options.subtitle, graphics);
        stringBounds = new Rectangle2D.Float(0f, 0f, (float) (stringBounds.getX() + stringBounds.getWidth()), (float) ( stringBounds.getHeight()));

        if (maxRect.contains(stringBounds)) {
            if (0 < diff) {
                diff = Math.abs(diff);
            } else if (diff < 0) {
                diff = Math.abs(diff) / 2;
            }
        } else {
            if (0 < diff) {
                diff = - Math.abs(diff) / 2;
            } else if (diff < 0) {
                if (size <= Math.abs(diff)) {
                    diff = - Math.abs(diff) / 2;
                } else {
                    diff = - Math.abs(diff);
                }
            }
        }
        size += diff;
    }

    subtitleX = (int) ((w/2) - (stringBounds.getWidth() / 2));
    subtitleY = (int) (h - maxRect.getHeight() + fontMetrics.getAscent());
}

graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
graphics.drawString(options.subtitle, subtitleX, subtitleY);