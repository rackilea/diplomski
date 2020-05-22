public abstract class YourAbstractClassTest {

    protected abstract YourAbstractClass getInstance();

    @Test
    public void testThing() {
        final YourAbstractClass instance = this.getInstance();
        instance.callMethod();

        Assertions.assertTrue(instance.someProperties());
    }
}