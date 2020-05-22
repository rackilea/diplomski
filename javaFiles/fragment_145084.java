public final class Domain {
    public static Book book() {
        return new Book(randomIsbn());
    }
    // etc...
}