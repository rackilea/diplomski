public Collection<Map<String, String>> get(Supplier<Collection<? extends Enum<?>>> supplier) {
    return supplier.get().stream().map(e -> {
      Map<String, String> map = new HashMap<>();
      // populate
      return map;
    }).collect(Collectors.toList());
}