public void doSomething(int i, int j)
{
  final int n = i + j; // must be declared final

  Comparator comp = new Comparator()
  {
    public int compare(Object left, Object right)
    {
      return n; // return copy of a local variable
    }
  };
}