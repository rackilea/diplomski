public class Test implements Runnable {
    private static final Logger LOG = LogManager.getLogger();
    private final String id;

    public Test(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        ThreadContext.put("id", id);    //org.apache.logging.log4j.ThreadContext
        while (true) {
            try { Thread.sleep(10000); } catch (InterruptedException e) { break; }
            LOG.info("{}: I have been sleeping for 10 seconds", id);
        }
    }
}