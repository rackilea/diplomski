Map<String, String> env = new HashMap<>();
env.put("create", "true");

Path path = Paths.get("foobar.epub");
URI uri = URI.create("jar:" + path.toUri());
FileSystem zipFs = FileSystems.newFileSystem(uri, env);
Path root = zipFs.getPath("/");
Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attrs) throws IOException {
        print(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir,
            BasicFileAttributes attrs) throws IOException {
        print(dir);
        return FileVisitResult.CONTINUE;
    }

    private void print(Path file) throws IOException {
        Date lastModifiedTime = new Date(Files.getLastModifiedTime(file).toMillis());
        System.out.printf("%td.%<tm.%<tY %<tH:%<tM:%<tS %9d %s\n", 
                lastModifiedTime, Files.size(file), file);
    }
});