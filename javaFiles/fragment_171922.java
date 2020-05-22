static void addTree(Path directory, Collection<Path> all)
        throws IOException {
    try (DirectoryStream<Path> ds = Files.newDirectoryStream(directory)) {
        for (Path child : ds) {
            all.add(child);
            if (Files.isDirectory(child)) {
                addTree(child, all);
            }
        }
    }
}