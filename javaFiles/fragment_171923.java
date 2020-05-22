static void addTree(Path directory, final Collection<Path> all)
        throws IOException {
    Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
            all.add(file);
            return FileVisitResult.CONTINUE;
        }
    });
}