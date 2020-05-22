public static <T> Codec<ISeq<ISeq<T>>, BitGene>
codec(final ISeq<? extends T> items, final int knapsackCount) {
    return Codec.of(
        Genotype.of(
            BitChromosome.of(items.length()).instances()
                .limit(knapsackCount)
                .collect(ISeq.toISeq())
        ),
        gt -> gt.stream()
            .map(ch -> ch.as(BitChromosome.class))
            .map(ch -> ch.ones()
                .<T>mapToObj(items)
                .collect(ISeq.toISeq()))
            .collect(ISeq.toISeq())
    );
}