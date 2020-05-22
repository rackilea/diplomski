public void close() throws IOException {
    try {
      flush();
    } catch (IOException ignored) {
    }
    out.close();
}