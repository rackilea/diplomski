String encodeAsUcs2(String messageContent) throws UnsupportedEncodingException {
  byte[] bytes = messageContent.getBytes("UTF-16BE");

  StringBuilder sb = new StringBuilder();
  for (byte b : bytes) {
    sb.append(String.format("%02X", b));
  }

  return sb.toString();
}