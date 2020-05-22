interface Interface
{
   void foo();
}

class Implementation
    implements Interface
{
    public void foo() { }
    public void bar() { }
}

public class Main
{
    public static void main(final String[] argv)
    {
        Interface a;
        Implementation b;

        a = new Implementation();
        b = a;

        a.foo();
        b.foo();
        a.bar(); <-  won't compile
        b.bar();
    }
}