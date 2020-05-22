generateUntil(this::nextInts, List::isEmpty).forEach(list -> {
    //do works
});

import static java.util.stream.StreamSupport.stream;

<T> Stream<T> generateUntil(final Supplier<T> generator, Predicate<T> stop) {
    long unknownSize = Long.MAX_VALUE;

    return stream(new AbstractSpliterator<T>(unknownSize, Spliterator.ORDERED) {
        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            T value = generator.get();

            if (stop.test(value)) {
                return false;
            }

            action.accept(value);
            return true;
        }
    }, false);
}