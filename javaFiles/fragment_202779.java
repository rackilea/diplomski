List<Foo> result = new ArrayList<>(
    myList.stream()
          .collect(Collectors.groupingBy(
              f -> Arrays.<String>asList(f.getType(), f.getCode()),
              MoreCollectors.pairing(
                 Collectors.collectingAndThen(MoreCollectors.first(), Optional::get),
                 Collectors.summingInt(Foo::getQuantity),
                 (f, s) -> new Foo(f.getType(), s, f.getCode())
              )
          )).values());