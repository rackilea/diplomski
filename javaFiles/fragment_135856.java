public FluentIterable<Map.Entry<String, Person>> tree() {
    if (persons == null)
        return FluentIterable.from(ImmutableList.of());
    return FluentIterable.from(persons.entrySet())
        .transformAndConcat(
            new Function<Entry<String, Person>, Iterable<Entry<String, Person>>>() {
            @Override
            public Iterable<Map.Entry<String, Person>> apply(
                    Map.Entry<String, Person> entry) {
                return Iterables.concat(ImmutableList.of(entry), entry.getValue().tree());
            }
        });
}