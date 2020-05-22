public static InputStream newThing(String name) throws IOException {
    return returnResource(
        () -> new FileInputStream(name),
        InputStream::close,
        in -> {
            int ignore = in.read(); // some work
        }
    );
}