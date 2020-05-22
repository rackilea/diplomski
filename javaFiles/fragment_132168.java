public class Blah {
    private BlockingQueue<String> queue;

    public Blah() {
        queue = new LinkedBlockingQueue<>(8);
    }

    public void produce(String action, String task) throws InterruptedException {
        while (true) {
            queue.put(action + "#" + task);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            final String[] data = queue.take().split("#");
            final String action = data[0];
            final String task = data[1];
        }
    }
}