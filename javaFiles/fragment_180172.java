public class Main {
    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) {
        LOG.info("Starting thread 1");
        Thread t1 = new Thread(new Test("mode1"));
        t1.start();
        LOG.info("Starting thread 2");
        Thread t2 = new Thread(new Test("mode2"));
        t2.start();
        LOG.info("Starting thread 3");
        Thread t3 = new Thread(new Test("mode3"));
        t3.start();
    }
}