public GifSequenceWriter(
        ImageOutputStream outputStream,
        ImageTypeSpecifier imageTypeSpecifier, 
        int timeBetweenFramesMS,
        boolean loopContinuously) throws IIOException, IOException {
    // my method to create a writer
    gifWriter = getWriter();
    imageWriteParam = gifWriter.getDefaultWriteParam();

    imageMetaData = gifWriter.getDefaultImageMetadata(imageTypeSpecifier, imageWriteParam);

    // ... rest of the method unchanged.