// You could pass a parameter to the URL to know if it's windows  
// or linux and set the path accordingly
String path = "c:/temp";

Path directory = Paths.get(path);
    Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {

        @Override
        public FileVisitResult visitFile(Path file,
                BasicFileAttributes attrs) throws IOException {
            Files.delete(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                throws IOException {
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
        }
    });