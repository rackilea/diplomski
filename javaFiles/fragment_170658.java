public class Main {
  static public void main(String args[]) throws Exception {
    int width = 200, height = 200;
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    Graphics2D ig2 = bi.createGraphics();
    ig2.fillRect(0, 0, width - 1, height - 1);

    Iterator imageWriters = getImageWritersByMIMEType("image/gif");
    ImageWriter imageWriter = (ImageWriter) imageWriters.next();
    File file = new File("filename.gif");
    ImageOutputStream ios = ImageIO.createImageOutputStream(file);
    imageWriter.setOutput(ios);
    imageWriter.write(bi);
  }