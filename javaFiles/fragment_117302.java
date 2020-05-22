.retryWhen(Retry.onlyIf(this::is5xxServerError)
        .fixedBackoff(Duration.ofSeconds(10))
        .retryMax(3))

private boolean is5xxServerError(RetryContext<Object> retryContext) {
    return retryContext.exception() instanceof WebClientResponseException &&
            ((WebClientResponseException) retryContext.exception()).getStatusCode().is5xxServerError();
}