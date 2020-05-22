if (! Arrays.stream(Food.values())
            .map(Enum::name)
            .collect(Collectors.toSet())
            .containsAll(Arrays.asList(sarr))) {
    doStuff();
}