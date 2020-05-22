/**
 * Posts <code>setFocus</code> to the display event queue.
 */
public void postSetFocusOnDialogField(Display display) {
    if (display != null) {
        display.asyncExec(
            new Runnable() {
                public void run() {
                    setFocus();
                }
            }
        );
    }
}