/**
 * Releases all of the native screen resources used by this
 * {@code Window}, its subcomponents, and all of its owned
 * children. That is, the resources for these {@code Component}s
 * will be destroyed, any memory they consume will be returned to the
 * OS, and they will be marked as undisplayable.
 * ...
 */
public void dispose() {
    doDispose();
}