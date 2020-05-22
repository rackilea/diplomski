public static final List<String> validColorList;
static {
    try {
        validColorList = Files.readAllLines(
            Paths.get(MyClass.class.getResource("color-list").toURI()));
    } catch(IOException|URISyntaxException ex) {
        throw new ExceptionInInitializerError(ex);
    }
}