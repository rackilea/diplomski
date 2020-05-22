public class OverridenSubClass extends SubClass {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Overriden finalize called, which calls super's finalize first");
    }
}