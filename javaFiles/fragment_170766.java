try (
    final FileSystem zipfs = FileSystems.newFileSystem(uri, map);
    final OutputStream out
        = Files.newOutputStream(zipfs.getPath("/t.json"));
) {
    out.write("\"hello\"".getBytes(StandardCharsets.US_ASCII));
    out.close();
}