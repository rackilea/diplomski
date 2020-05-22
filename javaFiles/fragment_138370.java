final Path warpath = Paths.get("path to your war file here");

final URI uri = URI.create("jar:" + warpath.toUri());

try (
    final FileSystem zipfs = FileSystems.newFileSystem(uri, Collections.emptyMap());
) {
    final Path templates = zipfs.getPath("/WEB-INF/classes/templates");
    // walk "templates" with Files.walkFileTree()
}