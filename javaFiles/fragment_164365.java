String text = "Happy, Happy, Joy, Joy";
double width = cmToPixel(13.0, 72.0);

BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = img.createGraphics();
float fontSize = pointToFit(width, text, font, g2d, 0, (float)width);

font = font.deriveFont(fontSize);
FontMetrics fm = g2d.getFontMetrics(font);
int height = fm.getHeight();
g2d.dispose();