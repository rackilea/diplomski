public static File createTempFile(String path) {
    String[] parts = path.split("/");
    File f = File.createTempFile(parts[parts.length - 1], ".tmp");
    f.deleteOnExit();
    try (Inputstream in = getClass().getResourceAsStream(path))  {
        Files.copy(in, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    return f;
}