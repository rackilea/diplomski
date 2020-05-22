public class Bar {
    public void bar() {
        System.out.println("Bar#bar()");
    }
}

public class Foo extends Bar {
    public void bar() {
        super.bar();
        System.out.println("Foo#bar()");
    }
}