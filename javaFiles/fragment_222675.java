ImageInputStream stream = ImageIO.createImageInputStream(input);
ImageReader reader = ImageIO.getImageReaders(stream).next(); // TODO: Test hasNext()
reader.setInput(stream);

int width = reader.getWidth(0);
int height = reader.getHeight(0);

ImageReadParam param = reader.getDefaultReadParam();

for (int y = 0; y < height; y += 100) {
     for (int x = 0; x < width; x += 100) {
          param.setSourceRegion(new Rectangle(x, y, 100, 100)); // TODO: Bounds check

          // Read a 100 x 100 tile from the image
          BufferedImage region = reader.read(0, param);

          // ...process region as needed...
     }
}