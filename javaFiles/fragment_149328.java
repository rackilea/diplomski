public static Stream<String> lines(FileChannel channel) {
    BufferedReader br = new BufferedReader(Channels.newReader(channel, "UTF-8"));
    return br.lines().onClose(() -> {
        try { br.close(); }
        catch (IOException ex) { throw new UncheckedIOException(ex); }
    });
}