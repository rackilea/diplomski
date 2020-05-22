@Configuration
public class WebConfigurer implements ServletContextInitializer {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);
        initFilter(servletContext, disps);
    }


    private void initFilter(ServletContext servletContext,
                                              EnumSet<DispatcherType> disps) {
        FilterRegistration.Dynamic myFilter =
            servletContext.addFilter("myFilter",
                new MyFilterClass(jwtSecret));

        // You can pass null as first parameter to below API calls
        myFilter.addMappingForUrlPatterns(disps, true, "/content/*");
        myFilter.addMappingForUrlPatterns(disps, true, "/app/*");
        myFilter.setAsyncSupported(true);
    }

}