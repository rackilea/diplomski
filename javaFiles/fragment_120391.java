import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

// http://stackoverflow.com/q/32358084/3080094
public class RandomWell {

    public static void main(String[] args) {

        try {

            final FilledPool<Integer> pool = new FilledPool<Integer>(100, 1000);
            final CountDownLatch syncStart = new CountDownLatch(3);

            Thread consumer = new Thread() {
                @Override public void run() {
                    // just to do something, keep track of amount of positive ints from pool
                    int positiveInt = 0;
                    int totalInts = 0;
                    try {
                        syncStart.countDown();
                        syncStart.await();
                        for(;;) {
                            int i = pool.take();
                            if (i > 0) {
                                positiveInt++;
                            }
                            totalInts++;
                            Thread.yield();
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Consumer stopped: " + positiveInt + " / " + (totalInts - positiveInt));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            consumer.start();

            Thread producer = new Thread() {
                @Override public void run() {
                    try {
                        Random r = new Random();
                        syncStart.countDown();
                        syncStart.await();
                        for(;;) {
                            int fillTotal = 0;
                            while (!pool.isMinFilled()) {
                                int fill = pool.getFillSize();
                                for (int i = 0; i < fill; i++) {
                                    pool.offer(r.nextInt());
                                }
                                fillTotal += fill;
                                // System.out.println("Pool size: " + pool.sizeFast());
                            }
                            System.out.println("Filled " + fillTotal);
                            pool.awaitNewFilling();
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Producer stopped.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            producer.start();
            syncStart.countDown();
            syncStart.await();

            Thread.sleep(100);

            producer.interrupt();
            consumer.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FilledPool<E> {

        private final LinkedBlockingQueue<E> pool;
        private final int minSize;
        private final int maxSize;
        private final Semaphore needFilling = new Semaphore(0);

        // producer starts filling initially
        private final AtomicBoolean filling = new AtomicBoolean(true);

        public FilledPool(int minSize, int maxSize) {
            super();
            this.minSize = minSize;
            this.maxSize = maxSize;
            pool = new LinkedBlockingQueue<E>();
        }

        public E take() throws InterruptedException {

            triggerFilling();
            E e = pool.take();
            return e;
        }

        private void triggerFilling() {

            if (!isFilling() && !isMinFilled() && filling.compareAndSet(false, true)) {
                needFilling.release();
                System.out.println("Filling triggered.");
            }
        }

        public void offer(E e) { pool.offer(e); }

        public void awaitNewFilling() throws InterruptedException {

            // must check on minimum in case consumers outpace producer
            if (isMinFilled()) {
                filling.set(false);
                needFilling.acquire();
            }
        }

        public int size() { return pool.size(); }
        public boolean isMinFilled() { return minSize < size(); }
        public int getFillSize() { return maxSize - size(); } 
        public boolean isFilling() { return filling.get(); }
    }
}