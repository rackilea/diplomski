public static <T> Collection<T> lazyCollection(Supplier<? extends Stream<T>> s) {
    return new AbstractCollection<T>() {
        public Iterator<T> iterator() { return s.get().iterator(); }
        public int size() { return (int)s.get().count(); }
        public Object[] toArray() { return s.get().toArray(); }
    };
}