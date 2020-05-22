Observable<Integer> vals = Observable.range(1,10);

vals.flatMap(val -> Observable.just(val)
            .subscribeOn(Schedulers.computation())
            .map(i -> intenseCalculation(i))
).subscribe(val -> System.out.println(val));