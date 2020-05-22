public class Counter extends Thread {
    private Demo mDemo;
    private int mAmount;

    public Counter(Demo demo, int amount) {
        // Remember the shared resource
        mDemo = demo;
        mAmount = amount;
    }

    @Override
    public void run() {
        for (int i < 0; i < mAmount; i++) {
            // Call the count method provided
            // by the shared resource
            mDemo.count();

            // Sleep some millis
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}