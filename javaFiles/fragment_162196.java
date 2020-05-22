@Bean
public ServletWebServerFactoryWrapper servletContainer() {
    if(sslEnabled) {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(redirectConnector());
        return ServletWebServerFactoryWrapper.getWrapper(tomcat);
    }
    return ServletWebServerFactoryWrapper.getWrapper(null);
}