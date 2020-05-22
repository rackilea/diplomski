private void handleWrite() throws IOException {
    String s = extractLine();
    for (int i = 0, len = s.length(); i < len;) {
        buffer.clear();
        while (buffer.remaining() > 1 && i < len) {
            buffer.putChar(s.charAt(i));
            ++i;
        }
        buffer.flip();
        channel.write(buffer);
    }
    // some other operations...
}