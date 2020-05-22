/**
     * Crop the main image according to this rectangle, and scale it to the
     * correct size for a thumbnail.
     */
    public InputStream cropAndScale(InputStream mainImageStream,
            CropRectangle crop) {
        try {
            RenderedOp mainImage = loadImage(mainImageStream);
            RenderedOp opaqueImage = makeImageOpaque(mainImage);
            RenderedOp croppedImage = cropImage(opaqueImage, crop);
            RenderedOp scaledImage = scaleImage(croppedImage);
            byte[] jpegBytes = encodeAsJpeg(scaledImage);
            return new ByteArrayInputStream(jpegBytes);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to scale the image", e);
        }
    }