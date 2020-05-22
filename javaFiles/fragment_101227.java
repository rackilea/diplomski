public class TestClassB {

    public TestClassA [] A;

    TestClassB (int num) {
        A = new TestClassA[num];
        for (int i=0; i < num; i++) {
            A[i] = new TestClassA(); // You need to INITIALIZE your Array
        }
    }
}