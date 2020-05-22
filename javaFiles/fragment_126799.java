private final Enumeration<? extends T> enumeration;

    public IterableEnumeration(final Enumeration<? extends T> e) {
        enumeration = e;
    }

    public static <T> Iterable<T> make(Enumeration<? extends T> en) {
        return new IterableEnumeration<T>(en);
    }