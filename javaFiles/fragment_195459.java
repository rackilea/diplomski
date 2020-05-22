static Optional<Type> componentType(Type type) {
  return Optional.of(type)
                 .filter(t -> t instanceof ParameterizedType)
                 .map(t -> (ParameterizedType) t)
                 .filter(t -> t.getActualTypeArguments().length == 1)
                 .filter(t -> Optional.of(t.getRawType())
                                      .filter(rt -> rt instanceof Class)
                                      .map(rt -> (Class<?>) rt)
                                      .filter(Stream.class::isAssignableFrom)
                                      .isPresent())
                 .map(t -> t.getActualTypeArguments()[0]);