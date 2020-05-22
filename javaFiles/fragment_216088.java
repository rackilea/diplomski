public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int index = 0; index < 100; index++) {
            try {
                System.out.println("Put " + index);
                queue.put(index);
            } catch (InterruptedException ex) {
            }
        }
    }

}

public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer value = queue.take();
                System.out.println("Took " + value);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }

}