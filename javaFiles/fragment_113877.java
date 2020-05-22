public FileVisitResult visitFile(Path file,
    BasicFileAttributes attrs) throws IOException {
    // if the filename inside the epub end with "*logo.jpg"
    if (file.endsWith("logo.jpg")) {
        // extract the file in directory /tmp/
        Files.copy(file, Paths.get("/tmp/",
            file.getFileName().toString()));
    }
    return FileVisitResult.CONTINUE;
}