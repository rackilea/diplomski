public class TwoThreads {

    public static void main(String args[]) throws InterruptedException {
        System.out.println("TwoThreads:Test");
        new TwoThreads().test();
    }

    // The end of the list.
    private static final Integer End = -1;

    static class Producer implements Runnable {

        final BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 1000; i++) {
                    queue.add(i);
                    Thread.sleep(1);
                }
                // Finish the queue.
                queue.add(End);
            } catch (InterruptedException ex) {
                // Just exit.
            }
        }

    }

    static class Consumer implements Runnable {

        final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            boolean ended = false;
            while (!ended) {
                try {
                    Integer i = queue.take();
                    ended = i == End;
                    System.out.println(i);
                } catch (InterruptedException ex) {
                    ended = true;
                }
            }
        }

    }

    public void test() throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Thread pt = new Thread(new Producer(queue));
        Thread ct = new Thread(new Consumer(queue));
        // Start it all going.
        pt.start();
        ct.start();
        // Wait for it to finish.
        pt.join();
        ct.join();
    }

}