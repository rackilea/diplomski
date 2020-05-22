class Phinally
{
  static class ExceptionTest extends Exception
  { public ExceptionTest(String message) { super(message); }  }

  public static void main(String[] args) throws ExceptionTest
  {
    try {
      System.out.println("Foo.");
      throw new ExceptionTest("throw from try"); 
    } finally {
      throw new NullPointerException("throw from finally");
    }    
  }
}