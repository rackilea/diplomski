public static Stream<Class<?>> streamOfAncestors(Class<?> klass) {
    final Iterator<Class<?>> iterator = new Iterator<Class<?>>() {
        @SuppressWarnings("unchecked")
        Class<?> k = klass.getSuperclass ();

        @Override
        public boolean hasNext() {
            return k != null;
        }

        @Override
        public Class<?> next() {
            Class<?> curr = k;
            k = k.getSuperclass ();
            return curr;
        }
    };
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
            iterator,
            Spliterator.ORDERED | Spliterator.IMMUTABLE), false);
}