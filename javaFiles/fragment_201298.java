List<String> list; // given a list of String

ImmutableTable result = list.parallelStream()
    .map(processor::process) // converts String to ImmutableTable
    .collect(ImmutableTable.Builder::new, ImmutableTable.Builder::putAll,
        (a, b) -> a.putAll(b.build())
    .build();