byte[] pixels = ((DataBufferByte) original.getRaster().getDataBuffer()).getData();

/*
 *  Code to process pixels (just as before)
 */

// Replace the ImageIO.read invocation with the following code
// Note that *pixels* must be in 8 bits/pixel (grayscale) for this to work,
// it is not cheating! :-)
BufferedImage convertedGrayscale = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
convertedGrayScale.getRaster().setDataElements(0, 0, width, height, pixels);

try {
    ImageIO.write(convertedGrayscale, "jpg", new File("converted-grayscale-002.jpg"));
} 
catch (IOException e) {
    System.err.println("IOException: " + e);
}