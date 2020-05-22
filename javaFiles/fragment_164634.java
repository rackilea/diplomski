public void readLogs() {
    try(Stream<Path> stream = Files.list(Paths.get("."))) {
        stream.filter(path -> path.toString().endsWith(".log"))
              .collect(Collectors.groupingBy(path -> {
                  final String s = path.getFileName().toString();
                  return s.substring(0, s.indexOf("."));
              }))
              .values().stream()
              .flatMap(List::stream)
              .flatMap(path -> {
                  try { return Files.lines(path); }
                  catch (IOException e) { throw new UncheckedIOException(e); }
              })
              .forEachOrdered(this::parseLogLine);
    } catch(IOException|UncheckedIOException e) {
        e.printStackTrace();
    }
}