final Path path = Paths.get("thefile");
final FileChannel fc = FileChannel.open(path, StandardOpenOption.WRITE,
    StandardOpenOption.READ);

// then later:

fc.truncate(80L);