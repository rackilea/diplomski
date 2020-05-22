private static String readString(final InputStream inputStream) throws IOException {
    final ByteArrayOutputStream result = new ByteArrayOutputStream();
    final byte[] buffer = new byte[1024];
    int length;

    while ((length = inputStream.read(buffer)) != -1) {
        result.write(buffer, 0, length);
    }

    return result.toString(StandardCharsets.UTF_8);
}