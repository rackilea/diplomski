public byte[] getImage(URL url) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    InputStream is = url.openStream ();
    byte[] b = new byte[4096];
    int n;
    while ( (n = is.read(b)) > -1 ) {
        baos.write(b, 0, n);
    }
    return baos.toByteArray();
}