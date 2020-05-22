private Stream<String> readAllLines(Path path) {
    try {
        return Files.lines(path);
    }
    catch(IOException e) {
        throw new UncheckedIOException(e);
    }
}