String textToSearchFor = "important";
final Pattern searchPattern =
    Pattern.compile(Pattern.quote(textToSearchFor));

Path startPath = Paths.get("D:\\users\\Desktop\\myRootDir");
Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {

    class FileInfo {
        final FileTime time;
        final Path path;

        FileInfo(Path path, FileTime time) {
            this.path = path;
            this.time = time;
        }
    }

    private final Map<Path, FileInfo> mostRecentFilesByDir =
        new HashMap<>();

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException e) {

        FileInfo mostRecentFile = mostRecentFilesByDir.remove(dir);
        if (mostRecentFile != null) {
            System.out.println(mostRecentFile.path);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attrs)
    throws IOException {

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.findWithinHorizon(searchPattern, 0) == null) {
                // Text not found.
                return FileVisitResult.CONTINUE;
            }
        }

        FileTime time = attrs.creationTime();
        Path dir = file.getParent();
        FileInfo info = mostRecentFilesByDir.get(dir);
        if (info == null || time.compareTo(info.time) > 0) {
            mostRecentFilesByDir.put(dir, new FileInfo(file, time));
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) {
        return FileVisitResult.CONTINUE;
    }
});