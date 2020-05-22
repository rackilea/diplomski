public interface SomeClass { // You'd probably want to name it something different

    public abstract void aMethod();

}


public class SubClass extends SomeClass {

    @Override
    public void aMethod() {
        // An error would occur if aMethod isn't here.
    }

}