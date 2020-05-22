// you may use this if the likelihood of a success is high; assumes
// reasonable costs for the validation and consists (repeatable) results
public ValidationResult isValid(final Thing thing) {
    return validators.stream()
      .map(v -> v.isValid(thing))
      .filter(ValidationResult::isValid)
      .findFirst()
      .orElseGet(() -> new ValidationResult(false, "All validators failed"
        + validators.stream().map(v -> v.isValid(thing)).collect(Collectors.toSet())));
}