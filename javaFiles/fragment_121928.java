List<Item> snoozles =
    response.data
            .searches
            .stream() // Stream<Search>
            .flatMap(search -> search.apples.stream()) // Stream<Apple>
            .flatMap(apple -> apple.pears.stream()) // Stream<Pear>
            .flatMap(pear -> pear.sets.stream()) // Stream<Set>
            .flatMap(set -> set.items.stream()) // Stream<Item>
            .filter(item -> item.baz.fooz.unit.equals("snafu")) // Stream<Item>
            .collect(Collectors.toList()); // List<Item>