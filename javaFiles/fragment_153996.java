public class GuiceConfigurator implements Module {
    public void configure(final Binder binder) {
        binder.bind(MyFilter.class);
        binder.bind(Dependency.class);
    }
}