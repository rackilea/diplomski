public static <X, Y, Z> SortedMap<X, Z> transformValues(Map<? extends X, ? extends Y> input, Function<Y, Z> function) {
    return input.keySet()
                .stream()
                .collect(Collectors.toMap(Function.identity(),
                                          key -> function.apply(input.get(key)),
                                          (v1, v2) -> {
                                              return v1;
                                          }, TreeMap::new));

}