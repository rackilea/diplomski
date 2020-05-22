public MyClass {
  private final List<InjectedObject> injectedObjects;

  @Inject
  public MyClass(Provider<InjectedObject> injectedObjectProvider) {
    injectedObjects = new ArrayList<InjectedObject>();
    for (int i = 0; i < 5; i++) {
      injectedObjects.add(injectedObjectProvider.get());
    }
  }
}