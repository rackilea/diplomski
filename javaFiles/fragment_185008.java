public interface GenericFunction<T, U, R> extends Function<T, R>, BiFunction<T, U, R> {
    @Override
    default <V> GenericFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        return new GenericFunction<T, U, V>() {
            @Override
            public V apply(final T t, final U u) {
                return after.apply(GenericFunction.this.apply(t, u));
            }

            @Override
            public V apply(final T t) {
                return after.apply(GenericFunction.this.apply(t));
            }
        };
    }
}