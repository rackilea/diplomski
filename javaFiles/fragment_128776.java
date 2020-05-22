[zippedObservable].filter(new Func1<String, Boolean>() {
    @Override
    public Boolean call(final String string) {
        return !TextUtils.isEmpty(string);
    }
})