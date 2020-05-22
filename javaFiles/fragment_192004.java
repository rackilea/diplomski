@Override
public void onStartup(final ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    DelegatingFilterProxy filter1 = new DelegatingFilterProxy("springSecurityFilterChain");
    filter1.setServletContext(servletContext);
    filter1.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
    DelegatingFilterProxy filter2 = new DelegatingFilterProxy("corsFilter");
    servletContext.addFilter("springSecurityFilterChain", filter1).addMappingForUrlPatterns(null, true, "/*");
    servletContext.addFilter("corsFilter",filter2).addMappingForUrlPatterns(null, false, "/*");
}