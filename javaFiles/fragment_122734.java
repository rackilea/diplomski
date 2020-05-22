private final class DefaultModule extends AbstractModule {
  protected void configure() {
    bind(PlugInRegistry.class); 

    MapBinder.newMapBinder(binder(), String.class, PlugIn.class);
    // Nothing else here
  }
}

interface PlugIn {
  void doStuff();
}