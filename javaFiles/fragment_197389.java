public class ClassB {

    private ClassA guice;

    @Inject //This will inject the dependencies used in the constructor arguments
    public ClassB(final ClassA guice) {
        this.guice = guice;
        guice.go();
    }

    public static void main(String[] args) {
        /**
         * If only type to type binding is required, you can skip creating a Module class &
         * bootstrap the injector with empty argument createInjector like used below. But, when
         * there are other kind of bindings like Type to Implementations defined in modules, you can use:
         * final Injector injector1 = Guice.createInjector(new GuiceModule1(), new GuiceModule2());
         */
        final Injector injector = Guice.createInjector();
        final ClassB b = injector.getInstance(ClassB.class); //This will create dependency graph for you and inject all dependencies used by ClassB and downwards
    }
}