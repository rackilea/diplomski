public class App {
    static class OddEven implements Runnable {
        private final SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        public void start() throws InterruptedException {
            Thread oddThread = new Thread(this);
            Thread evenThread = new Thread(this);
            oddThread.start();
            queue.put(1);
            evenThread.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int i = queue.take();
                    System.out.println(i + " (" + Thread.currentThread() + ")");
                    if (i == 10)
                        break;
                    queue.put(++i);
                    if (i == 10)
                        break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new OddEven().start();
    }
}