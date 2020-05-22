import static java.util.stream.Collectors.toList;

Optional<List<Accumulation>> result = LongStream.range(0, 1L << accumulations.size())
    .mapToObj(bits -> BitSet.valueOf(new long[] {bits}))
    .filter(bits -> 8 == bits.stream()
            .map(i -> accumulations.get(i).getCount())
            .sum()
    )
    .map(bits -> bits.stream()
            .mapToObj(accumulations::get)
            .collect(toList())
    )
    .findFirst();