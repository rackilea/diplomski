Files.walkFileTree(root, EnumSet.noneOf(FileVisitOption.class), 2, new SimpleFileVisitor<Path>() {
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()) {
            process(path);
        }
        return FileVisitResult.CONTINUE;
    }
});