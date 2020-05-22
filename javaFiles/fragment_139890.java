public static GenericInitializer<A, B> createInitializer(final Class<A> a,
    final Class<B> b) {
  return new GenericInitializer<A, B>(a, b);
}

final GenericInitializer<PingInteraction, PingInvocation> pingInitializer
    = createInitializer(PingInteraction.class, PingInvocation.class);