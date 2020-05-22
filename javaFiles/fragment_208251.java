package a;

public class TestB extends TestA
{
  public TestB(String a, String b){
     super(a,b);
  }

  public InnerA someMethod(String some, TestGeneric<TestSomeObject>.InnerGeneric inner)
  {
     return new InnerB(some, inner);
  }

  protected class InnerB extends InnerA
  {
     public InnerB(String a, TestGeneric<TestSomeObject>.InnerGeneric b)
     {
        super(a, b);
     }
  }
}