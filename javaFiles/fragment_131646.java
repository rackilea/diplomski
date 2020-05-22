public final class Client
{

  private final CaptureHelper<?> helper;

  <T> Client(RequestHandler<T> handler) {
    this.helper = new CaptureHelper<T>(handler);
  }

  public void go()
  {
    helper.request("go");
  }

  private final class CaptureHelper<T>
  {

    private final RequestHandler<T> handler;

    private T state;

    private CaptureHelper(RequestHandler<T> handler) {
      this.handler = handler;
    }

    private void request(String action)
    {
      state = handler.request(state, action);
    }

  }

}