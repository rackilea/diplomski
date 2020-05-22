/**
 * Run a block of code in a JPA transaction.
 *
 * @param name The persistence unit name
 * @param readOnly Is the transaction read-only?
 * @param block Block of code to execute
 * @param <T> type of result
 * @return code execution result
 */
public <T> T withTransaction(String name, boolean readOnly, Supplier<T> block);