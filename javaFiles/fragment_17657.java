public static byte[] getImageAsGIF(BufferedImage image) throws ImageFormatException, IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    ImageIO.write(image, "GIF", output);

    return output.toByteArray();
}