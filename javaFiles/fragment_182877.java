StringBuilder buffer = new StringBuilder();
try (InputStream encoded = ...) {
  Reader decoded = new InputStreamReader(encoded, StandardCharsets.UTF_8);
  char[] buffer = new char[1024];
  while (true) {
    int n = decoded.read(buffer);
    if (n < 0)
      break;
    buffer.append(buffer, 0, n);
  }
}
String verse = buffer.toString();