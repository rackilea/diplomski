public class ServletContextInjector implements ServletContextAware,InitializingBean {
    private ServletContext servletContext;

    public void setServletContext(ServletContext sc){ this.servletContext = sc; }

    public void afterPropertiesSet(){
        servletContext.setAttribute( /* whatever */ );
    }
}