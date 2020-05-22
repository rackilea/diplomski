private final AtomicInteger idCounter = new AtomicInteger();
private final CyclicBarrier barrier = new CyclicBarrier(4);
private final AtomicInteger doneCounter = new AtomicInteger();

public Runnable createRunnable() {
    return () -> {
        final int threadId = this.idCounter.getAndIncrement();

        boolean threadDone = false;
        boolean moreCharacters = true;
        while (true) {
            while (this.barrier.getNumberWaiting() != threadId) {
            }

            // Add to StringBuilder here...

            // Set the 'moreCharacters' flag as false once this thread
            // has handled its String.
            // They will still need to spin though, to make sure the
            // parties waiting keep adding up as appropriate.

            if (!moreCharacters && !threadDone) {

                // 'threadDone' used so that each thread only
                // increments the 'doneCounter' once.

                this.doneCounter.incrementAndGet();
                threadDone = true;
            }

            barrier.await();

            if (this.doneCounter.get() == 4) {
                // Exit out of the loop once all Threads are done.
                break;
            }
        }
    };
}