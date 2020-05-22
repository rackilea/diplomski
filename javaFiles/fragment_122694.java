private static final Instant EARLIEST_ALLOWED_ARTICLE = ...;

private Instant creationTimestamp;

public Article(Instant creationTimestamp, ...) {
    if (creationTimestamp.isBefore(EARLIEST_ALLOWED_ARTICLE)) {
        throw new IllegalArgumetnException(...);
    }
    this.creationTimestamp = creationTimestamp;
    ...
}