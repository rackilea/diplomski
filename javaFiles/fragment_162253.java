public class Counter extends Thread {
    private final int countFrom;
    private final int countTo;
    private final Counter counterToWaitFor;

    public Counter(final int countFrom, final int countTo, final Counter counterToWaitFor) {
        super();
        this.countFrom = countFrom;
        this.countTo = countTo;
        this.counterToWaitFor = counterToWaitFor;
    }

    @Override
    public void run() {
        if (this.counterToWaitFor != null) {
            try {
                this.counterToWaitFor.join();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = this.countFrom; i <= this.countTo; i++) {
            System.out.println("i= " + i);
        }
    }
}