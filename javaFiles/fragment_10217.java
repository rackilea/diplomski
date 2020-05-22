public class TestMethod {
private int a;

public static void main(String[] args) {
    TestMethod method = new TestMethod();
    method.wrapperMethod(args);

}

public void wrapperMethod(String[] args) {
    if (args != null) {
        a = 10;
    }
    sampleMethod(a);
}

public static void sampleMethod(int a) {
    // TODO Auto-generated method stub

}