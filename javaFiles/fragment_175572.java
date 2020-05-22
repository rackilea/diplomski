public String probeContentType(Path path) throws IOException {

    // Check contents first
    String fileContentDetect = tika.detect(path.toFile());
    if (!fileContentDetect.equals(MimeTypes.OCTET_STREAM)) {
        return fileContentDetect;
    }

    // Try file name only if content search was not successful
    String fileNameDetect = tika.detect(path.toString());
    if (!fileNameDetect.equals(MimeTypes.OCTET_STREAM)) {
        return fileNameDetect;
    }

    // Specification says to return null if we could not 
    // conclusively determine the file type
    return null;
}