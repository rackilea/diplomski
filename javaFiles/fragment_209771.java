public class GuiceNamedTest extends AbstractModule {

    public static void main(String[] args) {
        Injector i = Guice.createInjector(new GuiceNamedTest());
        i.getInstance(InstaceOne.class);
        i.getInstance(InstaceTwo.class);
    }

    @Override
    protected void configure() {
        Bean beanOne = new Bean();
        beanOne.name = "beanOne";

        Bean beanTwo = new Bean();
        beanTwo.name = "beanTwo";

        bind(Bean.class).annotatedWith(Names.named("one")).toInstance(beanOne);
        bind(Bean.class).annotatedWith(Names.named("two")).toInstance(beanTwo);

        bind(InstaceOne.class);
        bind(InstaceTwo.class);
    }


    public static class Bean {
        String name;
    }

    public static interface A {}

    public static class InstaceOne implements A {

        @javax.inject.Inject
        public InstaceOne(@Named("one") Bean b1) {
            System.out.println(b1.name);
        }
    }

    public static class InstaceTwo implements A {

        @javax.inject.Inject
        public InstaceTwo(@Named("two") Bean b1) {
            System.out.println(b1.name);
        }
    }

}