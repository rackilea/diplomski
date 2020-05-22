try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
    ImageIO.write(bufferedImage, "png", os);
    try(InputStream is = new ByteArrayInputStream(os.toByteArray())) {
        //...
    }
}