@ConfigurationProperties(prefix = "example")
public final class MyProps {

  private final String neededProperty;

  public MyProps(String neededProperty) {
    this.neededProperty = neededProperty;
  }

  public String getNeededProperty() { .. }
}