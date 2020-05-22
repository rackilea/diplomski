import org.junit.contrib.java.lang.system.EnvironmentVariables;

public void EnvironmentVariablesTest {
  @Rule
  public final EnvironmentVariables environmentVariables
    = new EnvironmentVariables();

  @Test
  public void setEnvironmentVariable() {
    environmentVariables.set("name", "value");
    assertEquals("value", System.getenv("name"));
  }
}