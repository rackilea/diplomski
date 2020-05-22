Observable<String> scanned = Observable.interval(1, TimeUnit.SECONDS)
            .scan(
                    Observable.just(""),
                    (cumulativeString, item) ->
                        cumulativeString
                          .flatMap(str -> stringAddition(str, item).toObservable())
            )
            .flatMap(it -> it);