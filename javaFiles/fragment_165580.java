// Using Guava (guava-libraries.googlecode.com)
InputStream data = response.getEntity().getContent();
try {
    OutputStream output = new FileOutputStream(filename);
    try {
        ByteStreams.copy(data, output);
    } finally {
        Closeables.closeQuietly(output);
    }
} finally {
}