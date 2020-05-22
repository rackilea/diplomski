// Note that you can use a `PathMatcher` for the name instead if you want
final BiPredicate<Path, BasicFileAttributes> filter =
    (path, attrs) -> path.getFileName().toString().endsWith(".java") && attrs.size() <= 1000L;

try (
    final Stream<Path> = Files.find(baseDir, Integer.MAX_VALUE, filter);
) {
    // process the stream
}