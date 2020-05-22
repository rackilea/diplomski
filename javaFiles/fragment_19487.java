public class YourTest {

    @Test
    public void testSomething() {
        Child child = new ChildWithDisabledBadMethod();

        child.methodToTest();

        //put your assertions here
    }

    private static class ChildWithDisabledBadMethod extends Child {
        protected void badMethod() {
        }
    }
}