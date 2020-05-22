public class MyWebAppInitializer extends AbstractDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        super.onStartup(container);

        com.github.greengerong.PreRenderSEOFilter seoFilter = new com.github.greengerong.PreRenderSEOFilter();
        FilterRegistration.Dynamic filter =  container.addFilter("prerender", seoFilter);
        filter.setInitParameter("prerenderToken", "123456789123456789");
        filter.addMappingForUrlPatterns(null , true, "/*");

        ServletRegistration.Dynamic initSysConfiguration
                = container.addServlet("initSysConfiguration", new InitSystemConfigurations());
        initSysConfiguration.setLoadOnStartup(1);
        initSysConfiguration.addMapping("/InitSystemConfigurations");

    }

    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("classpath:MyContext.xml");
        return appContext;
    }

    protected String[] getServletMappings() {
        return new String[] {"/api/*"};
    }

}