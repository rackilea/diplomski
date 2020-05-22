public class ConfigurableDispatcherServlet extends DispatcherServlet {

    private String contextParent;

    /**
     * Initialize and publish the WebApplicationContext for this servlet.
     * <p>
     * Delegates to {@link #createWebApplicationContext} for actual creation of
     * the context. Can be overridden in subclasses.
     * 
     * @return the WebApplicationContext instance
     * @see #setContextClass
     * @see #setContextConfigLocation
     */
    protected WebApplicationContext initWebApplicationContext() {
        // No fixed context defined for this servlet - create a local one.
        WebApplicationContext parent = WebApplicationContextUtils.getWebApplicationContext(getServletContext(),
                "org.springframework.web.servlet.FrameworkServlet.CONTEXT." + getContextParent());
        WebApplicationContext wac = createWebApplicationContext(parent);

        // Publish the context as a servlet context attribute.
        String attrName = getServletContextAttributeName();
        getServletContext().setAttribute(attrName, wac);
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Published WebApplicationContext of servlet '" + getServletName() +
                        "' as ServletContext attribute with name [" + attrName + "]");
        }
        if(this.logger.isInfoEnabled()) {
            this.logger.info(getServletName() + " is a child of " + parent.getDisplayName());
        }

        return wac;
    }

    public String getContextParent() {
        return contextParent;
    }

    public void setContextParent(String contextParent) {
        this.contextParent = contextParent;
    }
}