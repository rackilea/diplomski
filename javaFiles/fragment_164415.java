public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();

        for (int i = 0; i < 3; i++) {
            Counter counter = new Counter(demo, 1000);
            counter.start();
        }
    }

    // Provide a shared resource for all threads
    private int sharedCounter = 0;

    // Provide a count method for all threads
    // which is synchronized to ensure that no
    // strange behavior with non-atomic operations occurs
    public synchronized void count() {
        sharedCounter++;
    }
}