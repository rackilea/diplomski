import java.util.Map;
import java.util.concurrent.*;

public class BarEngine implements Engine {

    private static final int WORKER_COUNT = 5;
    private ExecutorService threadPool;

    public BarEngine() {
        this.threadPool = new ThreadPoolExecutor(1, WORKER_COUNT, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
    }

    // From Engine Interface
    @Override
    public void sendEvent(final Map<String, Object> data) {
        threadPool.submit(new FooWorker(data));
    }

    // From Engine Interface
    @Override
    public void shutDown() {
        this.threadPool.shutdown();
        // Shuts down engine

    }

    public static class FooWorker implements Runnable {

        private final Client client;
        private final Map<String, Object> data;

        public FooWorker(Map<String, Object> data) {
            client = Client.build(Thread.currentThread().getId());
            this.data = data;
        }

        @Override
        public void run() {
            try {
                if (null != data) {
                    sendEvent(data);
                }
            } catch (Throwable e) {
                //todo log
            }
        }

        private void sendEvent(Map<String, Object> data) {
            try {
                client.submit(data);
            } catch (Throwable e) {
                //todo log
            }
        }

        // dummy client classs
        public static class Client {

            public void submit(Map<String, Object> data) {
                // submits data
            }

            public static Client build(long id) {
                // Builds client
                return new Client();
            }
        }
    }
}