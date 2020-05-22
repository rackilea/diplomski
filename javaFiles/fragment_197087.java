/**
 * Matches the execution of any public method in a type with the
 * Transactional annotation, or any subtype of a type with the
 * Transactional annotation.
 */
private pointcut executionOfAnyPublicMethodInAtTransactionalType() :
    execution(public * ((@Transactional *)+).*(..)) && @this(Transactional);

/**
 * Matches the execution of any method with the 
 * Transactional annotation.
 */
private pointcut executionOfTransactionalMethod() :
    execution(* *(..)) && @annotation(Transactional);