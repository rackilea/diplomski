Path dir = Paths.get("/path/to/directory");

try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.c")) {
    for (Path file : stream) {
        // Do stuff with file
    }
}