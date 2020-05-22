public static void main(String[] args) throws InterruptedException {
    final List<Thread> adderThreads = new ArrayList<>();
    final List<Thread> atomicThreads = new ArrayList<>();
    AtomicLongVsLongAddr vs = new AtomicLongVsLongAddr();
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 1000; i++) {
        final AtomicLongThread atomicThread = vs.new AtomicLongThread();
        atomicThreads.add(atomicThread);
        atomicThread.start();
    }

    for (Thread thread : atomicThreads) {
        thread.join();
    }
    long endTime = System.currentTimeMillis();
    System.out.printf("AtomicLong--Number: %s, Time: %d\n", vs.al, endTime - startTime);
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 1000; i++) {
        final LongAdderThread adderThread = vs.new LongAdderThread();
        adderThreads.add(adderThread);
        adderThread.start();
    }
    for (Thread thread : adderThreads) {
        thread.join();
    }
    long res = vs.la.sum();
    endTime = System.currentTimeMillis();
    System.out.printf("LongAdder--Number: %s, Time: %d\n", res, endTime - startTime);

}