public class AppleModule extends AbstractModule {

  @Override
  public void configure() {
    ImmutableSet<Integer> sizes = ImmutableSet.of(1, 2, 3);
    ImmutableSet<Apple> apples = sizes.stream().map(Apple::new)
      .collect(ImmutableSet.toImmutableSet());

    bind(new TypeLiteral<ImmutableSet<Apple>>(){}).toInstance(apples);
  }
}