public class YourComponent {
  public static final int DEFAULT_REQUEST_TIMEFRAME_MILLISECONDS = 600000;

  public ReturnObject callService() {
    return callService(DEFAULT_REQUEST_TIMEFRAME_MILLISECONDS);
  }

  /** Package-private for testing. */
  ReturnObject callService(int timeframe) {
    /* Your implementation here. */
  }
}