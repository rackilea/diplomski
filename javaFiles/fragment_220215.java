package first;
public class Base
{
    protected void Foo() {}
}

// Yes, each class is really in its own file normally - but treat
// all the classes below as being in package "second"

package second;
public class Child extends Base
{
    public void OtherMethod(Object x)
    {
        ((Base) x).Foo(); // Invalid: Base is not Child or subclass
        ((Child) x).Foo(); // Valid: Child is Child
        ((GrandChild) x).Foo(); // Valid: GrandChild is subclass of Child
        ((OtherChild) x).Foo(); // Invalid: OtherChild is not Child or subclass
    }
}

public class GrandChild extends Child {}
public class OtherChild extends Base {}