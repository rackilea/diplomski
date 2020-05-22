public class MyClass {
    private MyClass() {}

    private static class LazyHolder {
        private static final MyClass myClass = new MyClass();
    }

    public static MyClass getInstance() {
        return LazyHolder.myClass;
    }
}