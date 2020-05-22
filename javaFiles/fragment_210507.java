InputStream input = new ByteArrayInputStream(form.getImageFileData());
Iterator<ImageReader> readers = ImageIO.getImageReaders(input);

if (!readers.hasNext()) {
    // TODO: Handle, return null or throw exception, whatever is more appropriate
}

ImageReader reader = readers.next();
reader.setInput(input);

try {
    ImageReadParam param = reader.getDefaultReadParam();
    int imageNo = 0;

    int width = reader.getWidth(imageNo);
    int height = reader.getHeight(imageNo);

    // If possible, create a destination image up front
    ImageTypeSpecifier type = reader.getRawImageType(imageNo);
    if (type != null) {
        param.setDestination(type.createBufferedImage(width, height));
    }

    // Decode into the destination
    BufferedImage image;
    try {
        image = reader.read(imageNo, param);
    }
    catch (IOException e) {
        if (e.getCause() instanceof ZipException && param.getDestination() != null) {
            // If we got here, the destination will contain a partial image
            // We'll use that.
            image = param.getDestination();
        }
        else {
            throw e;
        }
    }
}
finally {
    input.close();
}