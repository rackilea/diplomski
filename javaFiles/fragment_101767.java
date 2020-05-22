public interface SomeInterface<T extends SomeInterface<T>>
{
  public T getInterfaceImpl();

  public void setTitle(String text);
}