try {
  …
} catch (e) {
  var ex = @com.google.gwt.core.client.JavaScriptException::new(Ljava/lang/Object;)(e);
  @com.google.gwt.core.client.GWT::log(Ljava/lang/String;Ljava/lang/Throwable;)("Error doing …", ex);
}