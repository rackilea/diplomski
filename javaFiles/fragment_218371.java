/**
     * Returns an array of all {@code Window}s, both owned and ownerless,
     * created by this application.
     * If called from an applet, the array includes only the {@code Window}s
     * accessible by that applet.
     * <p>
     * <b>Warning:</b> this method may return system created windows, such
     * as a print dialog. Applications should not assume the existence of
     * these dialogs, nor should an application assume anything about these
     * dialogs such as component positions, <code>LayoutManager</code>s
     * or serialization.
     *
     * @see Frame#getFrames
     * @see Window#getOwnerlessWindows
     *
     * @since 1.6
     */
public static Window[] getWindows()