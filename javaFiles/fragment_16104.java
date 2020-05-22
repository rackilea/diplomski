public static String[] readAllFiles(String path) throws IOException {
    Map<Path, List<String>> readFiles = new TreeMap<>();
    Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            readFiles.put(file, Files.readAllLines(file, StandardCharsets.UTF_8));
            return FileVisitResult.CONTINUE;
        }
    });
    List<String> lines = new ArrayList<>();
    for (List<String> read : readFiles.values()) {
        lines.addAll(read);
    }
    return lines.toArray(new String[lines.size()]);
}