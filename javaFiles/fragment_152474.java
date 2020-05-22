public class ApplicationInfo implements ServletContextAware {
    private final FooService fooService;
    private ServletContext servletContext;

    public ApplicationInfo(FooService fooService) {
        this.fooService = fooService;
    }

    @PostConstruct
    public void init() {
        // now you fooService and servletContext are set
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}