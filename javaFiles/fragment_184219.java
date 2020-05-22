public void dispose () {
    /*
    * Note:  It is valid to attempt to dispose a widget
    * more than once.  If this happens, fail silently.
    */
    if (isDisposed ()) return;
    if (!isValidThread ()) error (SWT.ERROR_THREAD_INVALID_ACCESS);
    release (true);
}