private Double subtract(Double a, Double b) {
    return a - b;
}

// ...

Double delta =
    calculateResult(eventToProcess, Double.class, this::subtract);