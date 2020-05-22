private MyResult getResult(MyRequest request) {
    ExecutorService es = Executors.newFixedThreadPool(3);
    ListeningExecutorService les = MoreExecutorslisteningDecorator(es);

    ListenableFuture<?> lf1 = les.submit(getCallableForService1(request));
    ListenableFuture<?> lf2 = les.submit(getCallableForService2(request));
    ListenableFuture<?> lf3 = les.submit(getCallableForService3(request));
    ListenableFuture<List<?>> lfs = Futures.successfulAsList(lf1, lf2, lf3);

    // wait 7 sec for results
    List<?> res = lfs.get(7, TimeUnit.SEONDS);

    return extractRes(res);
}