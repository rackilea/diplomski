public class Foo
{
  // In JMX Console
  @Managed
  private boolean isBar;

  // Not in JMX Console
  private boolean isFoo;

  // In JMX Console
  @Managed
  public String getClassName()
  {
    return Foo.class.getName();
  }
}