class SimpleThread extends Thread {

    // this is local to an _instance_ of SimpleThread
    private long sleepTotal;

    public SimpleThread(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                long toSleep = Math.random() * 1000;
                // add it to our per-thread local total
                sleepTotal += toSleep;
                sleep(toSleep);
            } catch (InterruptedException e) {}
        }
        System.out.println("DONE!  " + getName());
    }
}