/**
 * The context of the initiator or null if not running.
 * @return the context (or null if not running)
 * @since 5.0
 */
public Context getContext() {
    if (this.leaderSelector == null) {
        return NULL_CONTEXT;
    }
    return this.context;
}