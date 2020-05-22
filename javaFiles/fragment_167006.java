public static <T> Collector<KeyAndValues<T>,
                              ImmutableListMultimap.Builder<String, T>, 
                              ImmutableListMultimap<String, T>> toImmutableMultimap()
  {
    return Collector.of(
        ImmutableListMultimap.Builder::new,
        (b, kav) -> b.putAll(kav.getKey(), kav.getValues()),
        (builder1, builder2) -> builder1.putAll(builder2.build()),
        (builder) -> builder.build());
  }