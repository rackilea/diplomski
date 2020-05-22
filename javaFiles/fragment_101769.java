public class AnotherSomeInterfaceImpl implements SomeInterface<SomeInterfaceImpl>
{
  private String title;

  @Override
  public SomeInterfaceImpl getInterfaceImpl()
  {
    return new SomeInterfaceImpl();
  }

  @Override
  public void setTitle( String text )
  {
    this.title = text;
  }
}