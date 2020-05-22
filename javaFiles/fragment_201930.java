public class MyGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Interface.class).to(Concrete.class);
    }
}