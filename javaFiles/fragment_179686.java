ImageInputStream iis = ImageIO.createImageInputStream(file);

Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

while (imageReaders.hasNext()) {
    ImageReader reader = (ImageReader) imageReaders.next();
    System.out.printf("formatName: %s%n", reader.getFormatName());
}