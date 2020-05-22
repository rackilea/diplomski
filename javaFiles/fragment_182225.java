public class DefaultNameModule extends AbstractModule() {
  @Override public void configure() {
    for (String name : YOUR_LIST_OF_NAMES) {
      if (properties.contains(name)) {
        bindConstant(properties.get(name)).annotatedWith(Names.named(name));
      } else {
        bind(Foo.class)
            .annotatedWith(Names.named(name))
            .toProvider(new MyProvider(name));
      }
    }
  }

  private static class MyProvider extends Provider<Foo> {
    final String name;

    MyProvider(String name) {
      this.name = name;
    }

    @Override public Foo get() {
      return someValueBasedOn(name);
    }
  }
}