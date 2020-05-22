public class ExamplePluginLifecycle implements PluginLifecycle {

    @Override
    public Collection<Injectable<?>> start(GraphDatabaseService graphDatabaseService,
                                           Configuration config) {
        final List<Injectable<?>> injectables = new ArrayList<>();
        return injectables;
    }

    @Override
    public void stop() {
    }
}