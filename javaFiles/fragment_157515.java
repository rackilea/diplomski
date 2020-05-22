final Path dir = Paths.get("/Users/MaxRuizTagle/Desktop/lvl/");

final DirectoryStream<Path> dirstream
    = Files.newDirectoryStream(dir, "*.txt");

final List<String> textFiles = new ArrayList<>();

for (final Path entry: dirstream)
    if (!Files.isHidden(entry))
        textFiles.add(entry.getFileName().toString());