public class PingPongMain {
    public static void main(String[] args) throws InterruptedException {
        boolean[] next = {false};
        AtomicInteger count = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            try {
                synchronized (next) {
                    for(;;) {
                        // handle spurious wake ups.
                        while (next[0])
                            next.wait();

                        System.out.println("ping");

                        // state change before notify
                        next[0] = true;
                        next.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                // expected
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                synchronized (next) {
                    for(;;) {
                        // handle spurious wake ups.
                        while (!next[0])
                            next.wait();

                        System.out.println("pong");

                        // state change before notify
                        next[0] = false;
                        next.notifyAll();

                        count.incrementAndGet();
                    }
                }
            } catch (InterruptedException e) {
                // expected
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(5000);
        t1.interrupt();
        t2.interrupt();
        System.out.println("Ping ponged " + count + " times in 5 seconds");

    }
}