public class MyClass {

    // This method calls other (overridable) methods on itself
    public void run() {
            doSetup();
            doAction();
            doCleanup();
    }

    /** 
     * These three methods could be abstract if there's no default behavior
     * for the superclass to implement. In this example, these are concrete 
     * (not abstract) methods because there is a default behavior.
     */

    protected void doSetup() {
            System.out.println( "Superclass doSetup()" );
    }

    protected void doAction() {
            System.out.println( "Superclass doAction()" );
    }

    protected void doCleanup() {
            System.out.println( "Superclass doCleanup()" );
    }
}