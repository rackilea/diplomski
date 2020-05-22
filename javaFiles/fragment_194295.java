protected byte[] convertToJpeg(byte[] tiffByteArray) {
    final BufferedImage tif = ImageIO.read(new ByteArrayInputStream(tiffByteArray))

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
    final ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next()
    writer.setOutput(new MemoryCacheImageOutputStream(byteArrayOutputStream))

    JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null)
    jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT)
    jpegParams.setCompressionQuality(0.4f)

    writer.write(null, new IIOImage(tif, null, null), jpegParams)

    return byteArrayOutputStream.toByteArray()
}