public static void main(String[] args) throws Exception {
    final File tmp = File.createTempFile("myBatch", "batch");
    try (final ReadableByteChannel channel = Channels.newChannel(App.class.getResourceAsStream("/com/mycompany/MyBatch.bat"));
            final FileChannel fileChannel = new RandomAccessFile(tmp, "rw").getChannel()) {
        final ByteBuffer bb = ByteBuffer.allocate(1024);
        while (channel.read(bb) > 0) {
            bb.flip();
            fileChannel.write(bb);
            bb.clear();
        }
    }
    tmp.setExecutable(true);
    //run script
}