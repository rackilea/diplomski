private Double probabilityFor(DiscreteDistribution d, Integer x) {
    Map<Integer, Double> probabilities = d.getProbabilities();
    return probabilities.getOrDefault(x, 0);
}

// ...

Double probability =
    calculateResult(eventToProcess,
                    DiscreteDistribution.class,
                    Integer.class,
                    this::probabilityFor);