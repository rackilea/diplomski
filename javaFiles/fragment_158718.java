/**
 * Allocates a <code>Date</code> object and initializes it so that
 * it represents the time at which it was allocated, measured to the
 * nearest millisecond.
 *
 * @see     java.lang.System#currentTimeMillis()
 */
public Date() {
    this(System.currentTimeMillis());
}