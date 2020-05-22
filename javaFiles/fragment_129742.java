/**
 * Constant returned by {@link #getTransactionState} indicating that no
 * transaction is currently open.
 */
static final int TRANSACTION_IDLE = 0;

/**
 * Constant returned by {@link #getTransactionState} indicating that a
 * transaction is currently open.
 */
static final int TRANSACTION_OPEN = 1;

/**
 * Constant returned by {@link #getTransactionState} indicating that a
 * transaction is currently open, but it has seen errors and will
 * refuse subsequent queries until a ROLLBACK.
 */
static final int TRANSACTION_FAILED = 2;