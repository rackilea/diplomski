long lineCount(Path path) {
    try (Stream<String> s = Files.lines(path, StandardCharsets.ISO_8859_1)) {
        return s.count();
    } catch (IOException ioe) {
        throw new UncheckedIOException(ioe);
    }
}