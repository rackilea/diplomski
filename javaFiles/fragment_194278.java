class Foo extends HttpServlet {
  private final Properties properties;

  Foo(Properties properties) {
    this.properties = checkNotNull(properties);
  }

  private void doSomething() {
    PrintStream ps = new PrintStream(new FileOutputStream(properties.getProperty("bar")));
    // ...
}