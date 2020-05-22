// if chances of successful validation are mixed or unpredictable
// or validation is so expensive that everything else doesn't matter
// stay with the loop
public ValidationResult isValid(final Thing thing) {
    final Set<ValidationResult> failedResults = new HashSet<>();
    for (Validator validator : validators) {
        final ValidationResult result = validator.isValid(thing);
        if (result.isValid()) {
            return result;
        }
        failedResults.add(result);
    }
    return new ValidationResult(false, "No successful validator: " + failedResults);
}