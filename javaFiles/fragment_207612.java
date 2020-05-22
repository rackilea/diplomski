BufferedImage img = new BufferedImage(WIDTH, HEIGHT, 
                                     BufferedImage.TYPE_BYTE_GRAY);
img.getRaster().setPixels(0, 0, WIDTH, HEIGHT, pixelData);

File output = new File("image.jpg");
try {
  ImageIO.write(img, "jpg", output);
} catch (IOException e) {
  e.printStackTrace();
}