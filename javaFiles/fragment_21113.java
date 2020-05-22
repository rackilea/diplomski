public class A extends BasePage{

    public A() {
        super("A");
        B pageB = new B();
        setResponsePage(pageB);
        pageB.init();
    }

}

public class B extends BasePage{

    public B() {
        super("B");
    }

    public init() {
        setResponsePage(new C());
    }

}