public class Parent<T extends Parent<T>> {
    public T foo() {
        return (T)this;
    }
}

public class Child extends Parent<Child> {
    public void childMethod() {
        System.out.println("childMethod called");
    }
}

Child child = new Child();
child.foo().childMethod(); // compiles