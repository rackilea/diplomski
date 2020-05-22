public MediaType getContentType(InputStream is, String fileName) {
    MediaType mediaType;
    Metadata md = new Metadata();
    md.set(Metadata.RESOURCE_NAME_KEY, fileName);
    Detector detector = new ContainerAwareDetector(tikaConfig.getMimeRepository());

    try {
        mediaType = detector.detect(is, md);
    } catch (IOException ioe) {
        whatever;
    }
    return mediaType;
}