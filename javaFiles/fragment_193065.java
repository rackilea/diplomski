@Listeners(AverageReport.class)
public class TestFactory {
    @Factory
    public Object[] create() {
        return new Object[] {
            new TestClass(1), new TestClass(2)
        };
    }
}