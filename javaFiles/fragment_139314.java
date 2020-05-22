public class ThreadKiller implements Runnable {

    DelayQueue<WaitForDeath> kill = new DelayQueue<>();

    private class WaitForDeath implements Delayed {

        final Thread t;
        final long finish;

        public WaitForDeath(Thread t, long wait) {
            this.t = t;
            this.finish = System.currentTimeMillis() + wait;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(finish - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            long itsFinish = ((WaitForDeath) o).finish;
            return finish < itsFinish ? -1 : finish == itsFinish ? 0 : 1;
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                WaitForDeath t = kill.take();
                if (t.t.isAlive()) {
                    // Interrupt it.
                    t.t.interrupt();
                }
            } catch (InterruptedException ex) {
                // Not sure what to do here.
            }
        }
    }

    public void registerThread(Thread t, long wait) {
        // Post it into the delay queue.
        kill.add(new WaitForDeath(t, wait));
    }
}

public void test() throws InterruptedException {
    // Testing the ThreadKiller.
    ThreadKiller killer = new ThreadKiller();
    Thread killerThread = new Thread(killer);
    killerThread.setDaemon(true);
    Thread twoSeconds = new Thread(new WaitAFewSeconds(2));
    Thread fourSeconds = new Thread(new WaitAFewSeconds(4));
    killer.registerThread(twoSeconds, 5000);
    killer.registerThread(fourSeconds, 3000);
    killerThread.start();
    twoSeconds.start();
    fourSeconds.start();
    System.out.println("Waiting");
    Thread.sleep(10 * 1000);
    System.out.println("Finished");
    killerThread.interrupt();
}