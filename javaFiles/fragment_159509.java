public class DummyDateModule extends SimpleModule {
  public DummyDateModule() {
      super("DummyDateModule", new Version(0, 0, 1, null));
  }

  @Override
  public void setupModule(SetupContext context) {
      context.setMixInAnnotations(Foo.class, DateMixin.class);
  }
}