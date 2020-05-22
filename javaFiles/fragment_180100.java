public class B extends A {
    public B() {
        this(TestJavaCodes.this);
    }
    private B(TestJavaCodes outer) {
        super((data1, type) -> outer.parentData = 1);
    }
}