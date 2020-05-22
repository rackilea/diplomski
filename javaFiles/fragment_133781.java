/** Utility method to register editor for this {@link DataObject}.
     * Call it from constructor with appropriate mimeType. The system will
     * make sure that appropriate cookies ({@link Openable}, {@link Editable},
     * {@link CloseCookie}, {@link EditorCookie}, {@link SaveAsCapable},
     * {@link LineCookie} are registered into {@link #getCookieSet()}.
     * <p>
     * The selected editor is <a href="@org-netbeans-core-multiview@/org/netbeans/core/api/multiview/MultiViews.html">
     * MultiView component</a>, if requested (this requires presence of
     * the <a href="@org-netbeans-core-multiview@/overview-summary.html">MultiView API</a>
     * in the system. Otherwise it is plain {@link CloneableEditor}.
     * 
     * @param mimeType mime type to associate with
     * @param useMultiview should the used component be multiview?
     * @since 7.27
     */
    protected final void registerEditor(final String mimeType, boolean useMultiview) {
        MultiDOEditor.registerEditor(this, mimeType, useMultiview);
    }