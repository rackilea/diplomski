public static String readResource(final String classpathResource) {
    try {
        final InputStream is = TestClass.class.getResourceAsStream(classpathResource);
        // TODO verify is != null
        final String content = IOUtils.toString(
            is, StandardCharsets.UTF_8);
        return content;
    } catch (final IOException e) {
        throw new UncheckedIOException(e);
    }
}