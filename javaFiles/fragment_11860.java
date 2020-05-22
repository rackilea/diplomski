public class AnotherStack<T>
{
  private final T[] values;
  private int loc = 0;

  // must use the suppress, as we are using a raw Object array
  //   which is necessitated as cannot make a generic array  
  // See Effective Java
  @SuppressWarnings("unchecked")
  public AnotherStack(int size)
  {
    values = (T[])new Object[size];
  }


  public void push(T val)
  {
      if (loc < values.length) {
          values[loc++] = val;
      }
      else {
          throw new IllegalStateException("Stack full");
      }
  }

  public T pop()
  {
      if (loc == 0) {
          throw new IllegalStateException("Stack empty");
      }
      return (values[--loc]);
  }

  // other methods
}