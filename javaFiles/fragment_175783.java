public static byte[] getBytesFromURL(URL url) throws IOException {
    InputStream in = null;
    ByteArrayOutputStream out = null;
    try {
        in = url.openStream();
        out = new ByteArrayOutputStream();
        int len;
        byte[] buf = new byte[1024 * 4];
        while ((len = in.read(buf)) >= 0) {
            out.write(buf, 0, len);
        }
        byte[] bytes = out.toByteArray();
        return bytes;

    } catch (IOException e) {
        throw e;
    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
            }
        }
    }
}