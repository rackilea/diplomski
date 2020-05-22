observable1.concatMap(new Func1<String, Observable<Boolean>>() {
    @Override
    public Observable<Boolean> call(final String string) {
        return observable2.contains(string);
    }
})