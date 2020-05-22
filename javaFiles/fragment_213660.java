List<String> inclusionPaths = Arrays.asList("elastic54", "elastic56", "elastic57", "elastic60");
Files.walkFileTree(Paths.get("d:/work/eclipse"), new SimpleFileVisitor<Path>() {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean printOut = StreamSupport.stream(file.getParent().spliterator(), false)
                .anyMatch(path -> inclusionPaths.stream().anyMatch(s -> path.toString().equals(s)));
        if (attrs.isDirectory() || !printOut) {
            return FileVisitResult.CONTINUE;
        }
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }
});