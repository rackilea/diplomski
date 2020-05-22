private void loadConfiguration() {
    properties = new Properties();
    // ...
    try (InputStream inputStream = Files.newInputStream(discoverRootDirectory())) {
        properties.load(inputStream);
    } catch (FileAccessException | IOException ex) {
        // ...
    }
}