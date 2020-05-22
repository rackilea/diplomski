abstract class B {
    private final BFactory factory;
    protected B(BFactory factory) {
        this.factory = factory;
    }
    public B foo() {
        return factory.create();
    }
}
interface BFactory {
    B create();
}