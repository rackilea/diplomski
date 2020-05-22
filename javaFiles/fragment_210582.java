@Test
public void name() throws Exception {
    Observable<String> stringObservable = Observable.fromArray("1", "2", "3")
            .flatMap(x -> {
                return Observable.defer(() -> {
                    try {
                        if (x.equals("2")) {
                            throw new NullPointerException();
                        }
                        return Observable.just(x + "-");
                    } catch (Exception ex) {
                        return Observable.error(ex);
                    }
                }).map(s -> {
                    if (s.equals("3-")) {
                        throw new IllegalArgumentException();
                    }
                    return s + s;
                }).take(1)
                        .zipWith(Observable.just("X"), (s, s2) -> s + s2)
                        .onErrorResumeNext(Observable.empty());
            });

    TestObserver<String> test = stringObservable.test();

    test.assertResult("1-1-X");
}