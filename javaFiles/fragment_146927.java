public abstract class AbstractClass {
    protected abstract AbstractClass newInstance(String str1, String str2);

    public void foo() {
        Object piece = newInstance("one", "two");
    }
}

public class MyClass extends AbstractClass {
    protected AbstractClass newInstance(String str1, String str2) {
        return new MyClass(str1, str2);
    }
}