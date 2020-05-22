private static class Blah
{
  public void finalize() { System.out.println("finalizing!"); }
}

private static void f() throws Throwable
{
   Blah blah = new Blah();
   blah.finalize();
}

public static void main(String[] args) throws Throwable
{
    System.out.println("start");
    f();
    System.gc();
    System.out.println("done");
}