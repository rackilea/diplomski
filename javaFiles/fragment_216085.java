public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            try {
                System.out.println("Put " + index);
                queue.put(index);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

}