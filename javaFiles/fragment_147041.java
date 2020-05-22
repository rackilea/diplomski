public class WebAppInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException
    {       
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter", new     HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*"); 
    }
}