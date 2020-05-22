public static void main(String[] args) {
    Observable<Long> secondIntervals =
            Observable.interval(1, TimeUnit.SECONDS);

    secondIntervals.subscribe(s -> System.out.println("Observable thread id: "
                                                      + Thread.currentThread().getId()));

    System.out.println("Main thread id: " + Thread.currentThread().getId());

    /* Hold main thread for 5 seconds
    so Observable above has chance to fire */
    sleep(5000);
}