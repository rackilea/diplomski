/**
 * Initiates an orderly shutdown in which previously submitted
 * tasks are executed, but no new tasks will be accepted.
 * Invocation has no additional effect if already shut down.
 *
 * <p>This method does not wait for previously submitted tasks to
 * complete execution.  Use {@link #awaitTermination awaitTermination}
 * to do that.
 *
 * @throws SecurityException if a security manager exists and
 *         shutting down this ExecutorService may manipulate
 *         threads that the caller is not permitted to modify
 *         because it does not hold {@link
 *         java.lang.RuntimePermission}{@code ("modifyThread")},
 *         or the security manager's {@code checkAccess} method
 *         denies access.
 */
void shutdown();