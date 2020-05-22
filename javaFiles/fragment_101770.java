public class AnotherSomeInterfaceImpl implements SomeInterface<String>
{

  private String title;

  @Override
  public String getInterfaceImpl()
  {
    return "Hello World";
  }

  @Override
  public void setTitle( String text )
  {
    this.title = text;
  }
}