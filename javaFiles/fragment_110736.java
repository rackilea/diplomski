Rectangle sourceRegion = new Rectangle(x, y, w, h); // The region you want to extract

ImageInputStream stream = ImageIO.createImageInputStream(input); // File or input stream
Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);

if (readers.hasNext()) {
    ImageReader reader = readers.next();
    reader.setInput(stream);

    ImageReadParam param = reader.getDefaultReadParam();
    param.setSourceRegion(sourceRegion); // Set region

    BufferedImage image = reader.read(0, param); // Will read only the region specified
}