// you may use this if the likelihood of a success is
// very low and/or you intent to utilize parallel processing
public ValidationResult isValid(final Thing thing) {
    Map<Boolean,Set<ValidationResult>> results = validators.stream()
        .map(v -> v.isValid(thing))
        .collect(Collectors.partitioningBy(ValidationResult::isValid, Collectors.toSet()));
    return results.get(true).stream().findAny()
        .orElseGet(() -> new ValidationResult(false,
                             "No successful validator: "+results.get(false)));
}