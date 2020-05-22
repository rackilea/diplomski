// Inject this value somehow, eg using Spring
private Clock clock;

public LocalDateTime methodThatGeneratesTime() {
    return LocalDateTime.now(clock); // Instead of just LocalDateTime.now()
}