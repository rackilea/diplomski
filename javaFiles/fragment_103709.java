/**
     * Encodes the image as a whole into PNG, then into Base64 and finally into an URI suitable for the HTML {@code <img>} tag.
     * 
     * @param image an image
     * @return image as URI (image within the URI)
     * @throws IIOException if there is a fault with an image writer
     * @throws IOException in case of a general I/O error
     */
    public static final String getImageSrcForWebEngine(RenderedImage image) throws IIOException, IOException
    {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", output);
        return "data:base64," + Base64.getMimeEncoder().encodeToString(output.toByteArray());
    }