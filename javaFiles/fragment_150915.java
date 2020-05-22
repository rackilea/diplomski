public void readFileToOutputStream(Path path, OutputStream os) throws IOException {
  try (InputStream fis = new FileInputStream(path.toFile());
       InputStream bis = new BufferedInputStream(fis)) {
    byte[] buffer = new byte[4096];
    int n;
    while ((n = bis.read(buffer)) >= 0) {
      os.write(buffer, 0, n);
    }
  }
}