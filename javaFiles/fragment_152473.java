@Component
public class ApplicationInfo {
    private final FooService fooService;

    @Autowired
    public ApplicationInfo(ServletContext servletContext, FooService fooService) {
        this.fooService = fooService;

        // do something here
    }
}