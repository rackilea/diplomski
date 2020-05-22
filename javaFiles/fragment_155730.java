public class WaitZero {
    private static AtomicInteger num = new AtomicInteger(0);
    private static boolean consumed = false;

    public static void main(String... args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = getMyCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(WaitZero::send);
            threadPoolExecutor.submit(WaitZero::receive);
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(60, TimeUnit.SECONDS);
    }

    private static void send() {
        synchronized (num) {
            try {
                while (!isConsumed()) {
                    num.wait();
                }
            } catch (InterruptedException ignored) {
                ignored.printStackTrace();
            }
            num.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " number updated: " + num);
            setConsumed(false);
            num.notifyAll();
        }
    }

    private static void receive() {
        synchronized (num) {
            try {
                while (isConsumed()) {
                    num.wait();
                }
            } catch (InterruptedException ignored) {
                ignored.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " number received: " + num);
            setConsumed(true);
            num.notifyAll(); // ToDo: when to use notify?
            // ToDo: what is monitor?
        }
    }

    private static boolean isConsumed() {
        return consumed;
    }

    private static void setConsumed(boolean consumed) {
        WaitZero.consumed = consumed;
    }
}