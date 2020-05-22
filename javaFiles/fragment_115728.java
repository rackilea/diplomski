final String[] lines = ...;
final ISeq<Genotype<IntegerGene>> population = Arrays.stream(lines)
    .mapToInt(Integer::parseInt)
    .mapToObj(i -> IntegerChromosome.of(IntegerGene.of(i, 0, 100)))
    .map(ch -> Genotype.of(ch))
    .collect(ISeq.toISeq());