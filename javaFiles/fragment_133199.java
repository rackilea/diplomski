final long networkTimeOut = 100;
final long databaseTimeOut = 100;

final TestScheduler scheduler = new TestScheduler();

final Observable<Integer> networkRate = ratesFromNetwork(scheduler)
    .timeout(networkTimeOut, TimeUnit.MILLISECONDS, scheduler)
    .doOnError(e -> System.err.println("Failed to get rates from network."));

final Observable<Integer> databaseRate = latestRatesFromDB(scheduler)
    .timeout(databaseTimeOut, TimeUnit.MILLISECONDS, scheduler)
    .doOnError(e -> System.err.println("Failed to get rates from database"))
    .onErrorResumeNext(Observable.empty())
    .firstOrDefault(-1);

databaseRate.concatWith(networkRate).distinct().skip(1)
    .subscribe(i -> System.out.println("Updating to " + i),
        System.err::println,
        () -> System.out.println("completed"));

scheduler.advanceTimeBy(200, TimeUnit.MILLISECONDS);