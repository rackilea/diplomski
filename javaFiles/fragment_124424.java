public static void copy(InputStream input,
      OutputStream output,
      int bufferSize)
      throws IOException {
    byte[] buf = new byte[bufferSize];
    int bytesRead = input.read(buf);
    while (bytesRead != -1) {
      output.write(buf, 0, bytesRead);
      bytesRead = input.read(buf);
    }
    output.flush();
  }