Observable.zip(
    service.itemById(1),
    service.itemById(2),
    service.itemById(3),
    service.itemById(4),
    service.itemById(5),
    (i1, i2, i3, i4, i5) -> new Tuple<>(i1, i2, i3, i4, i5))
    .observeOn(AndroidSchedulers.mainThread())
    .subscribeOn(Schedulers.io())
    .subscribe(
        tuple -> {
            // < use the tuple >
        },
        error -> {
            // ...
        }
    );