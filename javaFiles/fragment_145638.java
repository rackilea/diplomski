public abstract class A {

    // Make it protected so it can accessible by subclasses
    protected Object model;

    // Common behavior that will be inherited by subclasses
    public String someMethod() {
        if (model instanceof X) {
            return "x";
        } else {
            return "not x";
        }
    }
}

public class B extends A {

    // Subclasses may access superclasses fields if protected or public.
    public void someOtherMethod() {
        System.out.println(super.model.toString());
    }

}

public class C extends A {

    // You may wish to override a parent's method behavior
    @Override
    public String someMethod() {
        return "subclass implements it different";
    }

}