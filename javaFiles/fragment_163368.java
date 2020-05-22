public class MyEntryPoint implements EntryPoint {
    private static native int jsniMethod() /*-{
      return 1;
    }-*/;

    public void onModuleLoad() {
      jsniMethod();
    }
  }