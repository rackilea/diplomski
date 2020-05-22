public class A {
    protected void someOtherMethod() {
        // Do stuff specific to A here.
    }

    public void someMethod() {
        // Do some stuff

        someOtherMethod();

        // Do some more stuff
    }
}

public class B extends A {
    @Override
    protected void someOtherMethod() {
        // Empty implementation; B doesn't need to do this.
        // Or do stuff specific to B...
    }
}