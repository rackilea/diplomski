public class TestClass extends AbstractTestClass implements Operator {
    @Override
    public String call() throws Exception {
        return Operator.super.call();
    }
    @Override
    public String performOperation() {
        // do some operation
    }
}