void release (boolean destroy) {
    if ((state & DISPOSE_SENT) == 0) {
        state |= DISPOSE_SENT;
        sendEvent (SWT.Dispose);
    }
    if ((state & DISPOSED) == 0) {
        releaseChildren (destroy);
    }
    if ((state & RELEASED) == 0) {
        state |= RELEASED;
        if (destroy) {
            releaseParent ();
            releaseWidget ();
            destroyWidget ();
        } else {
            releaseWidget ();
            releaseHandle ();
        }
    }
}