public class ClassFromExtLib {
    public void foo(Object param) {
    }
}

public class MyClass extends ClassFromExtLib {
    @Override
    public void foo(Object param) {
         super.foo(param);
         //adding my own implementation...
    }
}