// AbstractBase.java
public abstract class AbstractBase {
    public final void method() {
        everybodyDoesThisStuff();
        doIndividualStuff();
    }

    abstract void doIndividualStuff();

    private void everybodyDoesThisStuff() {
        // stuff that everybody does
    }
}

// ConcreteClass.java
public class ConcreteClass extends AbstractBase {
    void doIndividualStuff() {
         // do my individual stuff
    }
}