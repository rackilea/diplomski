ListenableFuture<T> fnHelper() {
    return Futures.catching(Futures.transform(fnGrpc(), new Function<V, T>() {
        @Override
        public T apply(V v) {
            T t1 = f(v);
            return t1;
        }
    }),
    Exception.class, x -> immediateFuture(t2));
}