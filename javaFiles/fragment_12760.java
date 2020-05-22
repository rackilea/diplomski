private void search(File directory) throws IOException {
    Files.walk(directory.toPath())
        .filter(f -> {
            return f.getFileName().toString().endsWith(".java");
        })
        .forEach(f -> fileList.add(f.toFile().getAbsolutePath()));
}