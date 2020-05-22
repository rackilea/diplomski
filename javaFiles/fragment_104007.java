public interface Interface<T>
{
  public void myMethod(T x);
}

public interface ExtendedInterface<T, V> extends Interface<T>
{
  public void myMethod(V x);
}