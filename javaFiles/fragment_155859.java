CheckedFuture<X, Y> update(final X entry) {
    CheckedFuture<Boolean, Y> f = delete(entry);
    ListenableFuture<X> tr = Futures.transform(f, (Function<Boolean, X>) input -> entry);
    return Futures.makeChecked(tr, input -> (Y) input.getCause());
}

CheckedFuture<Boolean, Y> delete(final X entry) {
    return Futures.immediateFailedCheckedFuture(new Y());
}