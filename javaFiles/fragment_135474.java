ImageReader reader = ...;
reader.setInput(...);
IIOImage image = reader.readAll(0, null); // Important, also read metadata

RenderedImage renderedImage = image.getRenderedImage();

// Modify renderedImage as you like

ImageWriter writer = ImageIO.getImageWriter(reader);
ImageWriteParam param = writer.getDefaultWriteParam();
paran.setCompressionMode(MODE_COPY_FROM_METADATA); // This modes ensures closest to original compression

writer.setOutput(...);
writer.write(null, image, param); // Write image along with original meta data