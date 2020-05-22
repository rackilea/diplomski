@Override
public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    servletContext.addListener(new SessionListener());
    //BEGIN OF NEW CODE
    WebApplicationContext context = getContext();
    DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
    //we did all this to set the below flag
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",dispatcherServlet );
    //END OF NEW CODE
    FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
    encodingFilter.setInitParameter("encoding", "UTF-8");
    encodingFilter.setInitParameter("forceEncoding", "true");
    encodingFilter.addMappingForUrlPatterns(null, true, "/*");
}