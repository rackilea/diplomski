private void processFiles(final Path baseDir, final Consumer<? super Path> consumer,
    final Collection<BiPredicate<Path, BasicFileAttributes>> filters)
    throws IOException
{
    final BiPredicate<Path, BasicFileAttributes> filter = filters.stream()
        .reduce((t, u) -> true, BiPredicate::and);

    try (
        final Stream<Path> stream = Files.find(baseDir, Integer.MAX_VALUE, filter);
    ) {
        stream.forEach(consumer);
    }
}