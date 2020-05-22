/**
 * Creates an {@code ArrayBlockingQueue} with the given (fixed)
 * capacity and the specified access policy.
 *
 * @param capacity the capacity of this queue
 * @param fair if {@code true} then queue accesses for threads blocked
 *        on insertion or removal, are processed in FIFO order;
 *        if {@code false} the access order is unspecified.
 * @throws IllegalArgumentException if {@code capacity < 1}
 */
public ArrayBlockingQueue(int capacity, boolean fair) {...}