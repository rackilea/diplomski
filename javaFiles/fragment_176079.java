class Foo {

    // Your parameter class.
    class TrimParameterSet {
        double min, max;
    }

    static double fitness(final double[] values) {
        // Your fitness function.
        return 0;
    }

    public static void main(final String[] args) {
        final List<TrimParameterSet> valueSets = ...;

        final DoubleRange[] ranges = valueSets.stream()
            .map(p -> DoubleRange.of(p.min, p.max))
            .toArray(DoubleRange[]::new);

        final Codec<double[], DoubleGene> codec = Codecs.ofVector(ranges);
        final Engine<DoubleGene, Double> engine = Engine.builder(Foo::fitness, codec)
            .build();

        // ...
    }
}