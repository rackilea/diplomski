try (InputStream is = url.openStream(); OutputStream os = new FileOutputStream(destinationFile)) {
    byte[] b = new byte[2048];
    int length;
    while ((length = is.read(b)) != -1) {
        os.write(b, 0, length);
    }
}