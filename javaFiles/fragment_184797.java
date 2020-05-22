final Path p = Paths.get("/", "home", "text", "xyz.txt");
final PathMatcher filter = p.getFileSystem().getPathMatcher("glob:*.txt");
try (final Stream<Path> stream = Files.list(p)) {
    stream.filter(filter::matches)
          .forEach(System.out::println);
}