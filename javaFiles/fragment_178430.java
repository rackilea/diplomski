public static Stream<String> lines(Path path, Charset cs) throws IOException {
    BufferedReader br = Files.newBufferedReader(path, cs); // this could throw IOException
    try {
        return br.lines().onClose(asUncheckedRunnable(br));
    } catch (Error|RuntimeException e) {
        try {
            br.close();
        } catch (IOException ex) {
            try {
                e.addSuppressed(ex);
            } catch (Throwable ignore) {}
        }
        throw e;
    }
}