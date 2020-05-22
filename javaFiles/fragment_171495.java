public class MyClass {

    private MyClass() { }

    public static MyClass getInstance() {
        return new MyClass();
    }
}