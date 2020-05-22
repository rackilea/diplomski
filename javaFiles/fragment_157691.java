public class MyClass {
    private static final MyClass myClass = new MyClass();

    private MyClass() {}

    public static MyClass getInstance() {
        return myClass; 
    }
}