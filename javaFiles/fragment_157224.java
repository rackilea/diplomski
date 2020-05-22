final Path zipFile = Paths.get("path/to/file.zip");
final Path dstDir = Paths.get("path/to/destination/directory");

try (
    final FileSystem zipfs = MoreFileSystems.openZip(zipFile, true);
) {
    MoreFiles.copyRecursize(zipfs.getPath("/"), dstDir,
        RecursionMode.FAIL_FAST);
}