Observable<String> observable1 = Observable.from(new String[]{"A", "B", "C", "D"});
Observable<String> observable2 = Observable.from(new String[]{"E", "C", "B", "G", "J", "O"});

observable1.concatMap(new Func1<String, Observable<Boolean>>() {
    @Override
    public Observable<Boolean> call(final String string) {
        return observable2.contains(string);
    }
}).zipWith(observable1, new Func2<Boolean, String, String>() {
    @Override
    public String call(final Boolean contains, final String string) {
        return contains ? "" : string;
    }
}).filter(new Func1<String, Boolean>() {
    @Override
    public Boolean call(final String string) {
        return !TextUtils.isEmpty(string);
    }
}).subscribe(new Action1<String>() {
    @Override
    public void call(final String string) {
        Log.d("observable:", string);
    }
});