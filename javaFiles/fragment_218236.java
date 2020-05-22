Graphics2D g2d = (Graphics2D)g;
FontMetrics fontMetrics = g2d.getFontMetrics();

int width = fontMetrics.stringWidth("aString");
int height = fontMetrics.getHeight();

...