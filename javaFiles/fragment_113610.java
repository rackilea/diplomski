@Bean
public MethodInterceptor retryAdvice() {
    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
    backOffPolicy.setBackOffPeriod(delay);
    return RetryInterceptorBuilder.stateless().backOffPolicy(backOffPolicy)
            .maxAttempts(maxAttempts).build();
}