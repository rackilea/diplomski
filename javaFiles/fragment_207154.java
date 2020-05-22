public class Alerts {
  private final Alert foo;
  private final Alert bar;
  private final Alert baz;
  private final Alert quux;

  public Alerts(Alert foo, Alert bar, Alert baz, Alert quux) {
    this.foo = foo;
    this.bar = bar;
    this.baz = baz;
    this.quux = quux;
  }

  public Alert getFoo() { return foo; }
  // etc.

}

public Alerts makeAlerts(AlertBuilder builder) {
  return new Alerts(
    builder.buildAlert(a,b,c),
    builder.buildAlert(d,e,f),
    builder.buildAlert(g,h,i),
    builder.buildAlert(x,y,z));  
}