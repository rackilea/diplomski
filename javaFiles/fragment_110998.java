@Test
public void test() {
    Observable.just(1, 2)
            .flatMap(item -> Observable.just(item)
                    .subscribeOn(Schedulers.newThread())
                    .doOnNext(i -> System.out.println("Thread:" + Thread.currentThread())))
            .subscribe(System.out::println);
}