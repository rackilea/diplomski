public class MyPropertySource extends EnumerablePropertySource<MyClient> {
  @Override
  public Object getProperty(String name) {
    return /* your impl */;
  }

  @Override
  public String[] getPropertyNames() {
    return /* your impl here */;
  }
}