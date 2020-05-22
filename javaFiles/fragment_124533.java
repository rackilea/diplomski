int[] count = {0};
try {
    Files.walkFileTree(
            Paths.get(dir.getPath()), 
            new HashSet<FileVisitOption>(Arrays.asList(FileVisitOption.FOLLOW_LINKS)),
            Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
                        throws IOException {
                    System.out.printf("Visiting file %s\n", file);
                    ++count[0];
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) 
                        throws IOException {
                    System.err.printf("Visiting failed for %s\n", file);
                    return FileVisitResult.SKIP_SUBTREE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                                                         BasicFileAttributes attrs) 
                        throws IOException {
                    System.out.printf("About to visit directory %s\n", dir);
                    return FileVisitResult.CONTINUE;
                }
            });
} catch (IOException e) {
    // handle exception
}