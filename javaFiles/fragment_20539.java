void constrainedVersion() {
    final Codec<double[], DoubleGene> codec = Codecs
        .ofVector(DoubleRange.of(0, 1), 4);

    final Constraint<DoubleGene, Double> constraint = Constraint.of(
        pt -> isValid(codec.decode(pt.getGenotype())),
        (pt, g) -> {
            final double[] r = normalize(codec.decode(pt.getGenotype()));
            return newPT(r, g);
        }
    );
}

private static Phenotype<DoubleGene, Double> newPT(final double[] r, final long gen) {
    final Genotype<DoubleGene> gt = Genotype.of(
        DoubleChromosome.of(
            DoubleStream.of(r).boxed()
                .map(v -> DoubleGene.of(v, DoubleRange.of(0, 1)))
                .collect(ISeq.toISeq())
        )
    );
    return Phenotype.of(gt, gen);
}

private static boolean isValid(final double[] x) {
    return x[0] + x[1] + x[2] == 1 && x[3] > 0.8;
}


private static double[] normalize(final double[] x) {
    double[] r = x;
    final double sum = r[0] + r[1] + r[2];
    if (sum != 1) {
        r[0] /= sum;
        r[1] /= sum;
        r[2] /= sum;
    }
    if (r[3] > 0.8) {
        r[3] = 0.8;
    }
    return r;
}