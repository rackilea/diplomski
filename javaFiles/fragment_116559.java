public class Foo
{
  String var1 = null;
  String var2 = null;
  int var3 = 0;

  public static void main (String[] arguments)
  {
    Foo foo = new Foo(); // create an instance of this class
    foo.bar();           // execute a method on that instance
  }

  public void bar()
  {
    // here you can use the variables var1 through var3
    // you can also use them in any other non-static method in the class;
    // changing them in one method will make that change visible to the other.
  }
}