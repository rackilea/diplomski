/**
 * Concrete subaspects must implement this pointcut, to identify
 * transactional methods. For each selected joinpoint, TransactionMetadata
 * will be retrieved using Spring's TransactionAttributeSource interface.
 */
protected abstract pointcut transactionalMethodExecution(Object txObject);