public List<Bar> get(Optional<Foo> foo) {
     return foo.map(x -> x.getBazList()
                          .stream()
                          .map(Baz::getBar)
                          .collect(Collectors.toList()))
               .orElse(Collections.emptyList());
}