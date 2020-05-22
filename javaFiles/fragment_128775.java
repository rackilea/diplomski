[concatMapObservable].zipWith(observable1, new Func2<Boolean, String, String>() {
    @Override
    public String call(final Boolean contains, final String string) {
        return contains ? "" : string;
    }
}