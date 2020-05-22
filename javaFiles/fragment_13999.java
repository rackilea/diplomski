public static String parse(String segment, Charset... encodings) {
  byte[] data = parse(segment);
  for (Charset encoding : encodings) {
    try {
      return encoding.newDecoder()
          .onMalformedInput(CodingErrorAction.REPORT)
          .decode(ByteBuffer.wrap(data))
          .toString();
    } catch (CharacterCodingException notThisCharset_ignore) {}
  }
  return segment;
}

private static byte[] parse(String segment) {
  ByteArrayOutputStream buf = new ByteArrayOutputStream();
  Matcher matcher = Pattern.compile("%([A-Fa-f0-9][A-Fa-f0-9])")
                          .matcher(segment);
  int last = 0;
  while (matcher.find()) {
    appendAscii(buf, segment.substring(last, matcher.start()));
    byte hex = (byte) Integer.parseInt(matcher.group(1), 16);
    buf.write(hex);
    last = matcher.end();
  }
  appendAscii(buf, segment.substring(last));
  return buf.toByteArray();
}

private static void appendAscii(ByteArrayOutputStream buf, String data) {
  byte[] b = data.getBytes(StandardCharsets.US_ASCII);
  buf.write(b, 0, b.length);
}