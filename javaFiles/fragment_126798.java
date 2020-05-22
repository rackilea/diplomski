private final Enumeration<T> enumeration;

    public IterableEnumeration(final Enumeration<T> e) {
        enumeration = e;
    }

    public static <T> Iterable<T> make(Enumeration<T> en) {
        return new IterableEnumeration<T>(en);
    }