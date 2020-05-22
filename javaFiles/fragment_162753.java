// Warning: Untested. Please revise if needed.
public final class SomeModule<T> extends AbstractModule {
  private Class<T> t;

  public SomeModule(Class<T> t) {
    this.t = t;
  }

  @Override
  public void configure() {
    // Uses a class instance rather than reflection, so this is fine.
    bind(t).toProvider(new Provider<T>() {
      // ... do stuff
    });
  }
}