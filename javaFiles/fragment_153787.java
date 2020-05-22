public final String pollLine(final BufferedReader reader)
    throws IOException {
   /* pick a reasonable look ahead */
  reader.mark(512);
  while (reader.ready()) {
    final int ch = reader.read();
    if (ch == -1
            || Character.getType(ch) == Character.LINE_SEPARATOR) {
      reader.reset();
      return reader.readLine();
    } 
  }
  reader.reset();
  return null;
}