public static final Set<String> validColorList;
static {
    try {
        validColorList = new HashSet<>(Files.readAllLines(
            Paths.get(SO59045501.class.getResource("color-list").toURI())));
    } catch(IOException|URISyntaxException ex) {
        throw new ExceptionInInitializerError(ex);
    }
}