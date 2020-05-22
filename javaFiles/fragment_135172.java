log("Java version: " + System.getProperty("java.runtime.version"));

// get the reader
ImageReader ir = ImageIO.getImageReadersByFormatName("png").next();

// get the default param    
ImageReadParam p = ir.getDefaultReadParam();
p.setDestinationType(
    // define the image type to return if supported
    ImageTypeSpecifier.createInterleaved(
        ColorSpace.getInstance(ColorSpace.CS_sRGB), 
        new int[] {0, 1, 2, 3},    // <-- the order of the color bands to return so the bytes are in the desired order
        DataBuffer.TYPE_BYTE,
        true, false)
        );

InputStream stream = TestBufferedImage.class.getClassLoader().getResourceAsStream("test.png");

ImageInputStream imageStream = ImageIO.createImageInputStream(stream);
ir.setInput(imageStream);
BufferedImage image = ir.read(0, p);