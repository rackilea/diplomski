public class Parent {

    //package access
    void foo() {
    }
}

public class ChildPublic extends Parent {

    // Legal
    @Override
    public void foo() {
    }
}

public class ChildProtected extends Parent {
    // Legal
    @Override
    protected void foo() {
    }
}

public class ChildPrivate extends Parent {
    // Illegal
    /*
    @Override
    private void foo() {
    }
    */
}

public class SamePackageAccessTest {
    {
        new Parent().foo();

        //these have overriden foo()
        new ChildPublic().foo();
        new ChildProtected().foo();

        //this one had not overriden foo()
        new ChildPrivate().foo();
    }
}

package otherpackage;
import test.*;
public class OtherPackageAccessTest {

    {
        //Legal!
        new ChildPublic().foo();

        //illegal
        /*
        new ParentPackage().foo();
        new ChildProtected().foo();
        new ChildPrivate().foo();
        */

    }
}