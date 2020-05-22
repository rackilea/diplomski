public static BufferedImage rotateImage(BufferedImage src, double degrees) {
double radians = Math.toRadians(degrees);

int srcWidth = src.getWidth();
int srcHeight = src.getHeight();

/*
 * Calculate new image dimensions
 */
double sin = Math.abs(Math.sin(radians));
double cos = Math.abs(Math.cos(radians));
int newWidth = (int) Math.floor(srcWidth * cos + srcHeight * sin);
int newHeight = (int) Math.floor(srcHeight * cos + srcWidth * sin);

/*
 * Create new image and rotate it
 */
BufferedImage result = new BufferedImage(newWidth, newHeight,
    src.getType());
Graphics2D g = result.createGraphics();
g.translate((newWidth - srcWidth) / 2, (newHeight - srcHeight) / 2);
g.rotate(radians, srcWidth / 2, srcHeight / 2);
g.drawRenderedImage(src, null);

return result;
}