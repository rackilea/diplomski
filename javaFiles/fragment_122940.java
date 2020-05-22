static byte[] gzip(byte[] input) {
    GZIPOutputStream gzipOS = null;
    try {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        gzipOS = new GZIPOutputStream(byteArrayOS);
        gzipOS.write(input);
        gzipOS.flush();
        gzipOS.close();
        gzipOS = null;
        return byteArrayOS.toByteArray();
    } catch (Exception e) {
        throw new WebbException(e); // <-- just a RuntimeException
    } finally {
        if (gzipOS != null) {
            try { gzipOS.close(); } catch (Exception ignored) {}
        }
    }
}