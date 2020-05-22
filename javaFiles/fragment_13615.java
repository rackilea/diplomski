@Bean
public ServletContextAware endpointExporterInitializer(final ApplicationContext applicationContext) {
    return new ServletContextAware() {

        @Override
        public void setServletContext(ServletContext servletContext) {
            ServerEndpointExporter serverEndpointExporter = new ServerEndpointExporter();
            serverEndpointExporter.setApplicationContext(applicationContext);
            try {
                serverEndpointExporter.afterPropertiesSet();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }               
        }           
    };
}