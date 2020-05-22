private static Object lazyToString(final Supplier<String> stringSupplier) {
    return new Object() {
        @Override
        public String toString() {
            return stringSupplier.get();
        }
    };
}