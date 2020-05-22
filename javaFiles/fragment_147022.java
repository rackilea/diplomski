public class MySubclass extends MyClass {

    /**
     * Override a couple of the superclass methods to provide a different 
     * implementation.
     */

    @Override
    protected void doSetup() {
            System.out.println( "MySubclass doSetup()" );
    }

    @Override
    protected void doCleanup() {
            System.out.println( "MySubclass doCleanup()" );
    }
}