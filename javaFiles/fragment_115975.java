public class DiscreteDistribution {
    private final Map<Integer, Double> probabilities = new HashMap<>();

    // ...

    public Double probabilityOf(int x) {
        return probabilities.getOrDefault(x, 0);
    }
}

public class ValueCalculator {

    // ...

    Double probability =
        calculateResult(eventToProcess,
                        DiscreteDistribution.class,
                        Integer.class,
                        DiscreteDistribution::probabilityOf);

}