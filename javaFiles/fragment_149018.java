class Spy {
    static <T> Function<T,T> f2(Function<T,T> f) {
        return f.andThen(f);
    }

    static <T> T identity(T t) {
        return t;
    }
}