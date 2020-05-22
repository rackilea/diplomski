public final class ClassFromExtLib {
    public void foo(Object param) {
    }
}

public class MyClass {
    //code to initialize the instance of the class ommited
    private ClassFromExtLib bar;

    public void foo(Object param) {
         bar.foo(param);
         //adding my own implementation...
    }

    public void foo(Object param, Object param2) {
         bar.foo(param);
         //adding my own implementation using param and param2...
    }
}