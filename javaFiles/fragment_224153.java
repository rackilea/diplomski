public class MyAtomicInteger
{
  public synchronized increment()
  {
    x = x + 1;
  }

  private int x;
}