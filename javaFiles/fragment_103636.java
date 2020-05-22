Files.walkFileTree(file.toPath(),
    new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                                                 BasicFileAttributes attr)
        throws IOException {
            if (dir.endsWith("forbiddenDir")) {
                return FileVisitResult.SKIP_SUBTREE;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file,
                                         BasicFileAttributes attr)
        throws IOException {
            System.out.println("File = " + file);
            return FileVisitResult.CONTINUE;
        }
    });