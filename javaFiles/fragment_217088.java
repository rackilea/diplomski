package AA;
class A 
{
    public void foo() {}
    protected void bar() {}
}

package AA;
public class B extends A 
{

}

package BB;
public class C extends B
{
    public void func ()
    {
        super.bar (); // OK, since bar is protected and C extends B
                      // which extends A
    }
    public static void main (String[] args)
    {
        B b = new B();
        b.foo(); // OK, since foo is public
        b.bar(); // doesn't compile, since bar is protected
    }
}