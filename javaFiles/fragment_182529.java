public void copy(InputStream input, OutputStream output) throws IOException {
    byte[] buffer = new byte[1024];
    int len;

    while ((len = input.read(buffer, 0, buffer.length)) >= 0) {
        output.write(buffer, 0, len);
    }
}