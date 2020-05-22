public class SomeOtherClass {
    public void go(final MyClass myClass) {
        synchronized(myClass) {
            wait(Integer.MAXIMUM_VALUE);
        }
    }
}