/**
 * Class-style provider.
 * In module: bind(Foo.class).annotatedWith(Quux.class).toProvider(MyProvider.class);
 */
class MyProvider implements Provider<Foo> {
  @Inject Dep dep;  // All sorts of injection work, including constructor injection.

  @Override public Foo get() {
    return dep.provisionFoo("bar", "baz");
  }
}

/**
 * Method-style provider. configure() can be empty, but doesn't have to be.
 */
class MyModule extends AbstractModule {
  /** Name doesn't matter. Dep is injected automatically. */
  @Provides @Quux public Foo createFoo(Dep dep) {
    return dep.provisionFoo("bar", "baz");
  }

  @Override public void configure() { /* nothing needed in here */ }
}