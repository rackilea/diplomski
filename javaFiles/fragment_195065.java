public class GrizzlyServerShutdownHookThread extends Thread {

  public static final String THREAD_NAME = "Grizzly Server Shutdown Hook";

  public static final int GRACE_PERIOD = 60;
  public static final TimeUnit GRACE_PERIOD_TIME_UNIT = TimeUnit.SECONDS;

  private final HttpServer server;

  /**
   * @param server The server to shut down
   */
  public GrizzlyServerShutdownHookThread(HttpServer server) {
    this.server = server;
    setName(THREAD_NAME);
  }

  @Override
  public void run() {
    LOG.info("Running Grizzly Server Shutdown Hook.");
    LOG.info("Shutting down server.");
    GrizzlyFuture<HttpServer> future = server.shutdown(GRACE_PERIOD, GRACE_PERIOD_TIME_UNIT);

    try {
      LOG.info(format("Waiting for server to shut down... Grace period is %s %s", GRACE_PERIOD, GRACE_PERIOD_TIME_UNIT));
      future.get();
    } catch(InterruptedException | ExecutionException e) {
      LOG.error("Error while shutting down server.", e);
    }

    LOG.info("Server stopped.");
  }
}