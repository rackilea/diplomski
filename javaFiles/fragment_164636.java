public void readLogs() {
    try(Stream<Path> stream = Files.list(Paths.get("."))) {
        stream.filter(path -> path.toString().endsWith(".log"))
              .sorted(Comparator.comparing(path -> path.getFileName().toString()))
              .flatMap(path -> {
                  try { return Files.lines(path); }
                  catch (IOException e) { throw new UncheckedIOException(e); }
              })
              .forEachOrdered(this::parseLogLine);
    } catch(IOException|UncheckedIOException e) {
        e.printStackTrace();
    }
}