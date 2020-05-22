final Path dir = Paths.get("/Users/MaxRuizTagle/Desktop/lvl/");

final List<String> textFiles = Files.list(dir)
    .filter(path -> !Files.isHidden(path))
    .map(path -> path.getFileName().toString())
    .filter(s -> s.endsWith(".txt"))
    .collect(Collectors.toList());