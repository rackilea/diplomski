public static byte[] toByteArray(File f) throws IOException {
    if (f.length() > Integer.MAX_VALUE) {
        throw new IllegalArgumentException(f + " is too large!");
    }
    int length = (int) f.length();
    byte[] content = new byte[length];
    int off = 0;
    int read = 0;
    InputStream in = new FileInputStream(f);
    try {
        while (read != -1 && off < length) {
            read = in.read(content, off, (length - off));
            off += read;
        }
        if (off != length) {
            // file size has shrunken since check, handle appropriately
        } else if (in.read() != -1) {
            // file size has grown since check, handle appropriately
        }
        return content;
    } finally {
        in.close();
    }
}