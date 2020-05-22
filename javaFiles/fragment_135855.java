public FluentIterable<Map.Entry<String, Person>> tree() {
    if (persons == null)
        return FluentIterable.from(ImmutableList.of());
    return FluentIterable.from(persons.entrySet())
            .transformAndConcat(
                entry -> Iterables.concat(ImmutableList.of(entry), entry.getValue().tree()));
}