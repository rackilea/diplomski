public class ExampleEvent extends GwtEvent<ExampleEvent.Handler> {
  public interface Handler extends EventHandler {
    void onExample(Integer id);
    void onExample(String name);
  }

  private final Integer id;
  private final String name;

  public ExampleEvent(Integer id) {
    this.id = id;
    this.name = null;
  }

  public ExampleEvent(String name) {
    this.name = name;
    this.id = null;
  }

  public void dispatch(Handler handler) {
    if (name != null) {
      handler.onExample(name);
    } else {
      handler.onExample(id);
    }
  }
}