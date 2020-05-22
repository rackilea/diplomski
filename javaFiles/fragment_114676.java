public class PlainSocketClient extends AsyncThreadsTestRunnable {
    private static final String LOCK = "LOCK";

    @Override
    protected void execute() throws Exception {
        synchronized (LOCK) {
            final long startMillis = System.currentTimeMillis();
            try (Socket sock = new Socket(SRV_HOST, SRV_PORT)) {
                sock.getOutputStream().write(MSG);
            }
            NettyServerBossTest.this.actual.incrementAndGet();
            System.out.println("Client done. Duration: " + (System.currentTimeMillis() - startMillis));
        }
    }
}