/**
 * Specify a {@link TransactionInterceptor} {@link Advice} with default
 * {@code PlatformTransactionManager} and {@link DefaultTransactionAttribute} for the
 * {@link MessageHandler}.
 * @param handleMessageAdvice the flag to indicate the target {@link Advice} type:
 * {@code false} - regular {@link TransactionInterceptor}; {@code true} -
 * {@link org.springframework.integration.transaction.TransactionHandleMessageAdvice}
 * extension.
 * @return the spec.
 */
public S transactional(boolean handleMessageAdvice) {