public class DistributedProbabilityGeneratorBuilder<T extends DistributedProbabilityGeneratorBuilder.ProbableItem> {

    private static final DistributedProbabilityGenerator EMPTY = () -> {
        throw new UnsupportedOperationException("Not supported");
    };

    private final Map<Integer, T> distribution = new HashMap<>();

    private DistributedProbabilityGeneratorBuilder() {
    }

    public static <T extends ProbableItem> DistributedProbabilityGeneratorBuilder<T> newBuilder() {
        return new DistributedProbabilityGeneratorBuilder<>();
    }

    public DistributedProbabilityGenerator build() {
        return build(ProbableItem::getChances);
    }

    /**
     * Returns a new instance of probability generator at every call.
     * @param chanceChangeFunction - Function to modify existing chances
     */
    public DistributedProbabilityGenerator build(Function<T, Double> chanceChangeFunction) {
        if (distribution.isEmpty()) {
            return EMPTY;
        } else {
            return new NonEmptyProbabilityGenerator(createPairList(chanceChangeFunction));
        }
    }

    private List<Pair<Integer, Double>> createPairList(Function<T, Double> chanceChangeFunction) {
        return distribution.entrySet().stream()
                .map(entry -> Pair.create(entry.getKey(), chanceChangeFunction.apply(entry.getValue())))
                .collect(Collectors.toList());
    }

    public DistributedProbabilityGeneratorBuilder<T> add(int id, T item) {
        if (distribution.containsKey(id)) {
            throw new IllegalArgumentException("Id " + id + " already present.");
        }

        this.distribution.put(id, item);
        return this;
    }

    public interface ProbableItem {

        double getChances();
    }

    public interface DistributedProbabilityGenerator {

        int generateId();
    }

    public static class NonEmptyProbabilityGenerator implements DistributedProbabilityGenerator {

        private final EnumeratedDistribution<Integer> enumeratedDistribution;

        NonEmptyProbabilityGenerator(List<Pair<Integer, Double>> pairs) {
            this.enumeratedDistribution = new EnumeratedDistribution<>(pairs);
        }

        @Override
        public int generateId() {
            return enumeratedDistribution.sample();
        }
    }

    public static ProbableItem ofDouble(double chances) {
        return () -> chances;
    }
}