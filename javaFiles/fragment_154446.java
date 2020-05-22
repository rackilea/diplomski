try {
    return Files.readAllBytes(Paths.get(MyClass.class.getResource(path).toURI()));
} catch (IOException | URISyntaxException exception) {
    exception.printStackTrace();
}

return null;