public static void main(String[] args) throws IOException {
    final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:d:/**/*.zip");
    Files.walkFileTree(Paths.get("d:/"), new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (matcher.matches(file)) {
                System.out.println(file);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    });
}