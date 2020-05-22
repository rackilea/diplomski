public class SampleClass {
    public SampleClass() { super(); }
    public SampleClass(String s) { this(); }
    public SampleClass(int i) { this(); }
    public void method01(String s, Number n, Throwable t) {}
    public void method02(int i, String s, double d) {}
    public void method03(String s) {}
    public void method04() {}
    public void method05(String s, Number n, double d) {}

    public static void main(String[] args) {
        new SampleClass().method01("foo", new Integer(11), new RuntimeException("error"));
        new SampleClass("test").method02(11, "bar", Math.PI);
        new SampleClass(123).method03("zot");
        new SampleClass("another test").method04();
        new SampleClass(456).method05("baz", new Integer(11), Math.E);
    }
}