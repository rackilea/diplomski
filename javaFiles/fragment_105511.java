// A shortcut method for the below implementation: aggregates the whole result into a single list
private static <T> List<T> parseToListLenient(final JsonReader jsonReader, final IMapper<? super JsonReader, ? extends T> mapper)
        throws IOException {
    final List<T> list = new ArrayList<>();
    parseLenient(jsonReader, in -> list.add(mapper.map(in)));
    return list;
}

// A convenient strategy-accepting method to configure a JsonReader instance to make it lenient and do read
// The consumer defines the strategy what to do with the current JsonReader token
private static void parseLenient(final JsonReader jsonReader, final IConsumer<? super JsonReader> consumer)
        throws IOException {
    final boolean isLenient = jsonReader.isLenient();
    try {
        jsonReader.setLenient(true);
        while ( jsonReader.peek() != END_DOCUMENT ) {
            consumer.accept(jsonReader);
        }
    } finally {
        jsonReader.setLenient(isLenient);
    }
}

// Since Java 8 Consumer inteface does not allow checked exceptions to be rethrown
private interface IConsumer<T> {

    void accept(T value)
            throws IOException;

}

private interface IMapper<T, R> {

    R map(T value)
            throws IOException;

}