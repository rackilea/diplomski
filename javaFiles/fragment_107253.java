int dstWidth = 100;
int dstHeight = 100;
InputStream imageStream = item.getInputStream();
BufferedImage srcImage = ImageIO.read(imageStream);
if (srcImage == null) { System.err.println("NO SOURCE IMAGE!"); }
BufferedImage dstImage = new BufferedImage(dstWidth, dstHeight,
    BufferedImage.TYPE_INT_RGB);
dstImage.getGraphics().drawImage(
    srcImage, 0, 0, dstWidth, dstHeight, null);
ImageIO.write(dstImage, "jpg", new File(path + ".jpg"));