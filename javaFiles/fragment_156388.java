Observable.range(1, 5)
        .concatMap((i) -> {
            return Observable.range(i, 2);
        })
        .observeOn(Schedulers.computation())
        .concatMap((i) -> {
            return Observable.range(i, 2);
        })
        .subscribe((i) -> { System.out.println(i); }, System.out::println,() -> { System.out.println("Complete"); });
// block to let other schedulers finish
Thread.sleep(3000);