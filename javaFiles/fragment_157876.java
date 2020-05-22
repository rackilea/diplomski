private static final Semaphore foo = new Semaphore(1);
private static final Semaphore bar = new Semaphore(1);

private static void one() throws InterruptedException {
    foo.acquire();
    bar.acquire();
    bar.release();
    foo.release();
}

private static void two() throws InterruptedException {
    bar.acquire();
    foo.acquire();
    foo.release();
    bar.release();
}