public void findAllFilesInDirectory(Path pathToDir) throws IOException {
    Files.walkFileTree(pathToDir, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.isRegularFile(file)) {
                System.out.println(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    });
}