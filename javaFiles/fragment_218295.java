public class XmlWebApplicationContextLoader extends AbstractContextLoader {

    public final ConfigurableApplicationContext loadContext(final String... locations) throws Exception {
        ServletContext servletContext = new MockServletContext("war", new FileSystemResourceLoader());
        GenericWebApplicationContext webContext = new GenericWebApplicationContext();
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, webContext);
        webContext.setServletContext(servletContext);
        new XmlBeanDefinitionReader(webContext).loadBeanDefinitions(locations);        
        AnnotationConfigUtils.registerAnnotationConfigProcessors(webContext);
        webContext.refresh();
        webContext.registerShutdownHook();
        return webContext;
    }

    protected String getResourceSuffix() {
        return "";
    }