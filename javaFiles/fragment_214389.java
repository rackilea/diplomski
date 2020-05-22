public static void copyStream(final InputStream fromStream, final OutputStream toStream) throws IOException {
    byte[] buffer = new byte[4096];
    int bytesRead;
    while ((bytesRead = fromStream.read(buffer)) != -1) {
        toStream.write(buffer, 0, bytesRead);
    }
}