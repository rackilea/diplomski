private static final UniversalDetector DETECTOR = new UniversalDetector(null);

private static String getEncode(byte[] data) throws IOException {
    DETECTOR.reset();

    byte[] buf = new byte[data.length];
    InputStream is = new ByteArrayInputStream(data);

    int read;
    while ((read = is.read(buf)) > 0 && !DETECTOR.isDone()) {
        DETECTOR.handleData(buf, 0, read);
    }
    is.close();

    DETECTOR.dataEnd();
    return DETECTOR.getDetectedCharset();
}