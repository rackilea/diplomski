bindListener(Matchers.subclassesOf(MyInterface.class), new TypeListener() {
  public <I> void hear(TypeLiteral<I> typeLiteral,
                       TypeEncounter<I> typeEncounter) {
    myInterfaceBinder.addBinding().to(typeLiteral);
  }
}