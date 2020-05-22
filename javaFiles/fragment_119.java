static <T,R> Callable<R> mapAndfilter(T t, Function<T,R> f, Predicate<? super R> p) {
    return () -> {
        R r = f.apply(t);
        if(!p.test(r)) throw new NoSuchElementException();
        return r;
    };
}