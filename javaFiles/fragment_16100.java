int newImageWidth = imageWidth * zoomLevel;
int newImageHeight = imageHeight * zoomLevel;
BufferedImage resizedImage = new BufferedImage(newImageWidth , newImageHeight, imageType);
Graphics2D g = resizedImage.createGraphics();
g.drawImage(originalImage, 0, 0, newImageWidth , newImageHeight , null);
g.dispose();