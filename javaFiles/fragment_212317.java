/**
     * Specifies where users will go after authenticating successfully if they have not
     * visited a secured page prior to authenticating. This is a shortcut for calling
     * {@link #defaultSuccessUrl(String)}.
     *
     * @param defaultSuccessUrl the default success url
     * @return the {@link FormLoginConfigurer} for additional customization
     */
    public final T defaultSuccessUrl(String defaultSuccessUrl) {
        return defaultSuccessUrl(defaultSuccessUrl, false);
    }

    /**
     * Specifies where users will go after authenticating successfully if they have not
     * visited a secured page prior to authenticating or {@code alwaysUse} is true. This
     * is a shortcut for calling {@link #successHandler(AuthenticationSuccessHandler)}.
     *
     * @param defaultSuccessUrl the default success url
     * @param alwaysUse true if the {@code defaultSuccesUrl} should be used after
     * authentication despite if a protected page had been previously visited
     * @return the {@link FormLoginConfigurer} for additional customization
     */
    public final T defaultSuccessUrl(String defaultSuccessUrl, boolean alwaysUse) {
        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl(defaultSuccessUrl);
        handler.setAlwaysUseDefaultTargetUrl(alwaysUse);
        return successHandler(handler);
}