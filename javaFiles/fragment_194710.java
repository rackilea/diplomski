public class FooFactory implements Factory<Foo> {
    private final Bar theBar;

    @Inject
    public FooFactory(Bar bar) {
        theBar = bar;
    }

    @Override
    public Foo provide() {
        return Foo.newInstance(bar);
    }
}