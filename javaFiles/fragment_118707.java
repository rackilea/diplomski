import org.testng.annotations.Test;

public class SampleTestClass {
    @Test(groups = {"Report Formatting : Data"})
    public void testMethodA() {
        throw new RuntimeException("Intentionally failing the test");
    }

    @Test(groups = {"Report Formatting : Column & Row Headings and Border"})
    public void testMethodB() {
        System.err.println("testMethodB()");
    }
}