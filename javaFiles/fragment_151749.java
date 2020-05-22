public class SomeClass
{
  // This is the original constructor
  public SomeClass()
  {
    // Do some process
  }

  // New constructor expecting num > 0
  private SomeClass(int num)
  {
    // Do whatever you want
  }

  public static SomeClass getIt(int num) throws Exception
  {
    if (num < 0)
      throw new Exception("...");
    else if (num > 0)
      return (new SomeClass(num));
    else
      return (new SomeClass());
  }

} // SomeClass