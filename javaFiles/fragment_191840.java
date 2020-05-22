public class FooModule extends PrivateModule {
  @Retention(RUNTIME) @BindingAnnotation
  private @interface Internal {}

  @Override protected void configure() {
    bind(new TypeLiteral<IFoo<SomeType>>(){}).annotatedWith(Internal.class)
        .to(new TypeLiteral<Foo<SomeType>>(){});
  }

  @Provides @Exposed IFoo<SomeType> provideFoo(@Internal IFoo<SomeType> foo) {
    return new FooWrapper<SomeType>(foo);
  }
}