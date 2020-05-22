public class Foo {
  public Foo()
  {
    {System.out.println("Foo init");} // initializer.
    {System.out.println("Foo constr");}
  }
}

public class Main extends Foo {
  public Main()
  {  
    super(); // super constructor.
    {System.out.println("Main init");} // initializer.
    {System.out.println("Main constr");}
  }
  public static void main(String[] args) {
    new Main();
  }
}