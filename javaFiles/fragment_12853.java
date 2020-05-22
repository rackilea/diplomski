@Provides
  ImmutableSet<Apple> provideAppleBasket() {
    ImmutableSet<Integer> sizes = ImmutableSet.of(1, 2, 3);
    ImmutableSet<Apple> apples = sizes.stream().map(Apple::new)
      .collect(ImmutableSet.toImmutableSet());
    return apples;
  }