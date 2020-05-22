@Configuration
@ConditionalOnProperty(prefix = "server.error.whitelabel", name = "enabled", matchIfMissing = true)
@Conditional(ErrorTemplateMissingCondition.class)
protected static class WhitelabelErrorViewConfiguration {

    private final SpelView defaultErrorView = new SpelView(
            "<html><body><h1>Whitelabel Error Page</h1>"
                    + "<p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p>"
                    + "<div id='created'>${timestamp}</div>"
                    + "<div>There was an unexpected error (type=${error}, status=${status}).</div>"
                    + "<div>${message}</div></body></html>");

    @Bean(name = "error")
    @ConditionalOnMissingBean(name = "error")
    public View defaultErrorView() {
        return this.defaultErrorView;
    }

    // rest of the configuration
}