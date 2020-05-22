public class AbstractClassTest {
    private final AbstractClass instance = new AbstractClass() {
        @Override
        public void abstractMethod() {
            throw new UnsupportedOperationException();
        }
    }

    @Test
    public void testThing() {
        this.instance.concreteMethod();
        // Just make sure this doesn't ever go near the
        // methods you dummied up above...
    }
}