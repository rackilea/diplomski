try {
  …
} catch (e) {
  var ex = @com.google.gwt.core.client.JavaScriptException::new(Ljava/lang/Object;)(e);
  @com.google.gwt.core.client.GWT::reportUncaughtException(Ljava/lang/Throwable;)(ex);
}