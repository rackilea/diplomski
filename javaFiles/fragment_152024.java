private RetryTemplate getRetryTemplate() {
    RetryTemplate retryTemplate = new RetryTemplate();

    ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
    exponentialBackOffPolicy.setInitialInterval(INITIAL_INTERVAL_FOR_RETRYING);
    retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);

    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(MAX_ATTEMPTS);

    ExceptionClassifierRetryPolicy exceptionClassifierRetryPolicy = new ExceptionClassifierRetryPolicy();
    Map<Class<? extends Throwable>, RetryPolicy> policyMap = new HashMap<>();
    policyMap.put(IOException.class, retryPolicy);
    exceptionClassifierRetryPolicy.setPolicyMap(policyMap);
    retryTemplate.setRetryPolicy(exceptionClassifierRetryPolicy);

    return retryTemplate;
}