public byte[] consume(InputStream in) throws Exception {
  ByteArrayOutputStream out = new ByteArrayOutputStream();
  byte[] buffer = new byte[2048];
  int read = -1;
  while ((read = in.read(buffer)) > 0) {
    out.write(buffer, 0, read);
  }
  return out.toByteArray();
}