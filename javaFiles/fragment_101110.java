public class TestPy {

    private Thread thread;

    public void die() {
        synchronized (thread) {
            thread.interrupt();
        }    
    }

    public TestPy() {
        thread = new Thread(){
            public void run() {
                try {
                    while (!Thread.interrupted()) {
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        thread.start();    
    }

    public static void main(String[] args) {
        TestPy tp = new TestPy();
        GatewayServer server = new GatewayServer(tp);
        server.start();
    }
}