// Create input stream
ImageInputStream input = ImageIO.createImageInputStream(hdrFile);

try {
    // Get the reader
    Iterator<ImageReader> readers = ImageIO.getImageReaders(input);

    if (!readers.hasNext()) {
        throw new IllegalArgumentException("No reader for: " + hdrFile);
    }

    ImageReader reader = readers.next();

    try {
        reader.setInput(input);

        // Disable default tone mapping
        HDRImageReadParam param = (HDRImageReadParam) reader.getDefaultReadParam();
        param.setToneMapper(new NullToneMapper());

        // Read the image, using settings from param
        BufferedImage image = reader.read(0, param);
    }
    finally {
        // Dispose reader in finally block to avoid memory leaks
        reader.dispose();
    }
}
finally {
    // Close stream in finally block to avoid resource leaks
    input.close();
}

// Get float data
float[] rgb = ((DataBufferFloat) image.getRaster().getDataBuffer()).getData();

// TODO: Custom tone mapping on float RGB data

// Convert the image to something easily displayable
BufferedImage converted = new ColorConvertOp(null).filter(image, new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB));

// Optionally write as JPEG or other format
ImageIO.write(converted, "JPEG", new File(...));