public static String readFile(String path, Charset encoding) throws IOException {
  byte[] encoded = Files.readAllBytes(Paths.get(path));
  return encoding.decode(ByteBuffer.wrap(encoded)).toString();
}

yourComponent.setText(readFile(openf.getFile(), Charset.defaultCharset()));