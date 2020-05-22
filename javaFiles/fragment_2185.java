//untested code
public String parseID3String(DataInputStream in) throws IOException {
  String[] encodings = { "ISO-8859-1", "UTF-16", "UTF-16BE", "UTF-8" };
  String encoding = encodings[in.read()];
  byte[] terminator =
      encoding.startsWith("UTF-16") ? new byte[2] : new byte[1];
  byte[] buf = terminator.clone();
  ByteArrayOutputStream buffer = new ByteArrayOutputStream();
  do {
    in.readFully(buf);
    buffer.write(buf);
  } while (!Arrays.equals(terminator, buf));
  return new String(buffer.toByteArray(), encoding);
}