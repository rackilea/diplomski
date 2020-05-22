Observable<Integer> vals = Observable.range(1,10);

vals.subscribeOn(Schedulers.computation())
          .map(i -> intenseCalculation(i))
          .subscribe(val -> System.out.println("Subscriber received "
                  + val + " on "
                  + Thread.currentThread().getName()));