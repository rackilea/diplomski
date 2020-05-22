abstract class DefaultApplication implements Application {
  private final String name;

  protected DefaultApplication(String name) {
    this.name = name;
  }

  protected DefaultApplication() {
    this("DefApp");
  }

  public String getName() {
    return name;
  }
}

class MyApp extends DefaultApplication {

  public MyApp() {
    super("My App");
  }

}