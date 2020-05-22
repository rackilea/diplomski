private static Collector<Collection<SomeClassB>, ?, ImmutableList<SomeClassB>>
        flatMapToImmutableList() {
        return Collectors.collectingAndThen(Collectors.toList(),
                listOfCollectionsOfB ->
                        listOfCollectionsOfB.stream()
                                .flatMap(Collection::stream)
                                .collect(GuavaCollectors.toImmutableList()));
    }