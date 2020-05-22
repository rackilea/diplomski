@Override
public Runnable take() throws InterruptedException {
    int c = 0;
    ThreadLocalRandom rand = ThreadLocalRandom.current();

    while (true) {
        // Check internal first
        Runnable r = internalQueue.poll();
        if (r != null) {
            return r;
        }

        // Spin for a while on external, with occasional yield.
        while(c < 128)
        {
            r = externalQueue.poll();
            if (r != null) {
                return r;
            }

            if(rand.nextInt(32) == 0)
            {
                Thread.yield();
            }

            c++;
        }

        // Use the transfer queues time limited poll.
        r = externalQueue.poll(10000, TimeUnit.NANOSECONDS);
        if (r != null) {
            return r;
        }
    }
}