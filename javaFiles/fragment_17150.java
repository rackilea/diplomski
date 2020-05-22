// Util method to make it easier to transform a stream into a byte array
static byte[] streamToBytes(InputStream stream) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if (stream != null) {
        byte[] buf = new byte[1024];
        int r;
        while ((r = stream.read(buf)) != -1) {
            baos.write(buf, 0, r);
        }
    }
    return baos.toByteArray();
}