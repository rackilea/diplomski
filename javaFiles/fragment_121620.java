class YourClass {
  @Inject Injector injector;

  SomeInterface yourMethod(String input) {
    Class<? extends SomeInterface> clazz = getClassLiteralFromInput(input);
    return injector.getInstance(clazz);
  }

  Class<? extends SomeInterface> getClassLiteralFromInput(String input) {
    // Implement this as needed.
    return SomeInstance.class;
  }
}