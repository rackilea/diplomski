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
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(JavaApplication220.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}