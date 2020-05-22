Map<List<String>, Integer> map = 
    myList.stream()
          .collect(Collectors.groupingBy(
             f -> Arrays.asList(f.getType(), f.getCode()),
             Collectors.summingInt(Foo::getQuantity)
          ));

List<Foo> result = 
    map.entrySet()
       .stream()
       .map(e -> new Foo(e.getKey().get(0), e.getValue(), e.getKey().get(1)))
       .collect(Collectors.toList());