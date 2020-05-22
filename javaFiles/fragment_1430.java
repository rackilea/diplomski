obsOfA.flatMap(new Func1<A, Observable<B>>() {
    @Override
    public Observable<B> call(A a) {
        return obsOfB;
    }
})
.subscribe(/* obsOfB has completed */);