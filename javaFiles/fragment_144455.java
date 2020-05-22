// pre-Java7/8 way via recursive listFiles (8037 files returned): 1521.657 msec.
for (File f : new File(dir).listFiles()) {
    if (f.isDirectory()) {
        _getFiles(files, path, pattern);
    } else {
        ...
    }
}

// Files.walk(8037 files returned): 1575.766823 msec.
try (Stream<Path> stream = Files.walk(path, Integer.MAX_VALUE) {
    files = stream.filter(p -> {
        if (Files.isDirectory(p)) { return false; } // this extra check makes it much slower than Files.find
        ... 
    }).map(p -> p.toString()).collect(Collectors.toList());
}

// Files.find(8037 files returned): 27.606675 msec.
try (Stream<Path> stream = Files.find(path, Integer.MAX_VALUE, (p, a) -> !a.isDirectory())) {
    files = stream.filter(p -> { ... }).map(p -> p.toString()).collect(Collectors.toList());
}

// Files.walkFileTree(8037 returned): 27.443974 msec.
Files.walkFileTree(new File(path).toPath(), new SimpleFileVisitor<Path>() { 
    @Override
    public FileVisitResult visitFile(Path p, BasicFileAttributes attrs) throws IOException {
        ...
        return FileVisitResult.CONTINUE;
    }
});