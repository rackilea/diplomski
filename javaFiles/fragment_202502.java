public static void main(String args[]) {
    AtomicInteger tally = new AtomicInteger(0);
    List<Thread> threadList = new ArrayList<Thread>();
    for (int i = 0; i < 10; i++) {
        Thread t = new Thread(new DoThing(tally));
        t.start();
        threadList.add(t);
    }
    for (Thread t : threadList) {
        try { t.join(); } catch (Exception e){}
    }
    System.out.println("Total tally: " + tally.get());
}

public static class DoThing implements Runnable {
    private static final Random rand = new Random();
    private final AtomicInteger tally;

    public DoThing(AtomicInteger tally) {
        this.tally = tally;
    }

    @Override public void run() {
        for (int i = 0; i < 100; i++) {
            int currTally  = tally.incrementAndGet();
            System.out.println("Thread " + Thread.currentThread().getName() + ": " + currTally);
            // Random sleep to show that your threads are properly concurrently incrementing
            try { Thread.sleep(rand.nextInt(10)); } catch (Exception e) {}
        }
    }
}