public class ClientBundleCodeSplittingExample implements EntryPoint {

  public interface MyResources extends ClientBundle {
    public static final MyResources INSTANCE = GWT.create(MyResources.class);

    @ClientBundle.Source("resource1.txt")
    public TextResource resource1();

    @ClientBundle.Source("resource2.txt")
    public TextResource resource2();
  }

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    Window.alert("Resource 1: " + MyResources.INSTANCE.resource1().getText());

    GWT.runAsync(new RunAsyncCallback() {
      @Override
      public void onFailure(Throwable throwable) {
        Window.alert("Code download failed");
      }

      @Override
      public void onSuccess() {
        Window.alert("Resource 2: " + MyResources.INSTANCE.resource2().getText());
      }
    });
  }
}