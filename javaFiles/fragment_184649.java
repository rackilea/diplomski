public abstract class BaseClass {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("BaseClass finalisation occured");
    }
}