String readLine(BufferedInputStream bin) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    for (;;) {
        int ch = bin.read();
        if (ch == -1) {
            break;
        }
        if (ch == '\r' || ch == '\n') {
            if (ch == '\r') {
                bin.read();
            }
            break;
        }
        baos.write(ch);
    }
    return baos.toString("ISO-8859-1"); // Basic Latin-1 encoding.
}