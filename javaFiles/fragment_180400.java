public class ConcreteSubclassTest extends YourAbstractClassTest {
    private final ConcreteSubclass instance = new ConcreteSubclass();

    @Override
    protected YourAbstractClass getInstance() {
        return this.instance;
    }

    @Test
    public void moreTesting() {
        this.instance.implementationSpecificMethod();
    }
}