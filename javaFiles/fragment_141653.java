URL url = new URL("SOME_URL.txt");
URLConnection conn = url.openConnection();

ByteBuffer buffer = ByteBuffer.allocate(conn.getContentLength());
EventQueue.invokeLater(() -> progressBar.setMaximum(buffer.limit()));
EventQueue.invokeLater(() -> progressBar.setValue(0));
try (ReadableByteChannel channel = Channels.newChannel(conn.getInputStream())) {
    while (channel.read(buffer) >= 0) {
        EventQueue.invokeLater(() -> progressBar.setValue(buffer.position()));
    }
}

buffer.flip();
String rawG = StandardCharsets.UTF_8.decode(buffer).toString();