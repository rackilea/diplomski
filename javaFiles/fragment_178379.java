class Module extends AbstractModule {
  @Override protected void configure() {
    MapBinder.newMapBinder(binder(), String.class, ActionObject.class)
        .addBinding("dog").to(ActionObjectDog.class);
    MapBinder.newMapBinder(binder(), String.class, ActionObject.class)
        .addBinding("cat").to(ActionObjectCat.class);
  }
}

class ActionHandler {
  private final Map<String, ActionObject> mappings;
  @Inject ActionHandler(Map<String, ActionObject> mappings) {
    this.mappings = mappings;
  }

  public void doSomething(String message) {
    Preconditions.checkNotNull(mappings.get(message), "No action for '" + message + "'")
        .run();
  }
}