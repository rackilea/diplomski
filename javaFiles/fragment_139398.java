@Test
public void schedulerFinallyShutdown() throws InterruptedException {
    ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
    Logger logger = Loggers.getLogger("foo");
    CountDownLatch latch = new CountDownLatch(1);
    reactor.core.scheduler.Scheduler s = Schedulers.newElastic("X");
    Flux.range(1, 10000)
        .publishOn(s)
        .concatWith(Flux.<Integer>empty().doOnComplete(() -> {
            for (ThreadInfo ti : threadMxBean.dumpAllThreads(true, true)) {
                System.out.println("last element\t" + ti.getThreadName() + " " + ti.getThreadState());
            }
        }))
        .doFinally(sig -> {
            s.dispose();
            logger.info("Shut down all Scheduler worker threads");
            latch.countDown();
        })
        .filter(x -> x % 1000 == 0)
        .materialize()
        .subscribe(x -> logger.info(x+ "**"));

    latch.await();
    for (ThreadInfo ti : threadMxBean.dumpAllThreads(true, true)) {
        System.out.println("after cleanup\t" + ti.getThreadName() + " " + ti.getThreadState());
    }
}