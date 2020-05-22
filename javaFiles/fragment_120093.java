public class MyCustomContentNegotiationManagerFactoryBean extends ContentNegotiationManagerFactoryBean {
    @Override
    public void afterPropertiesSet() {
        List<ContentNegotiationStrategy> strategies = new ArrayList<ContentNegotiationStrategy>();

        if (!this.ignoreAcceptHeader) {
            strategies.add(new HeaderContentNegotiationStrategy());
        }

        if (this.favorPathExtension) {
            PathExtensionContentNegotiationStrategy strategy;
            if (this.servletContext != null && !isUseJafTurnedOff()) {
                strategy = new ServletPathExtensionContentNegotiationStrategy(
                        this.servletContext, this.mediaTypes);
            }
            else {
                strategy = new PathExtensionContentNegotiationStrategy(this.mediaTypes);
            }
            strategy.setIgnoreUnknownExtensions(this.ignoreUnknownPathExtensions);
            if (this.useJaf != null) {
                strategy.setUseJaf(this.useJaf);
            }
            strategies.add(strategy);
        }

        if (this.favorParameter) {
            ParameterContentNegotiationStrategy strategy =
                    new ParameterContentNegotiationStrategy(this.mediaTypes);
            strategy.setParameterName(this.parameterName);
            strategies.add(strategy);
        }

        if (this.defaultNegotiationStrategy != null) {
            strategies.add(this.defaultNegotiationStrategy);
        }

        this.contentNegotiationManager = new ContentNegotiationManager(strategies);
    }
}