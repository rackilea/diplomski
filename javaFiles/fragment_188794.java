@Configuration
public class ControllerConfiguration implements WebMvcConfigurer {

    private final AdminOnlyInterceptor adminInterceptor;

    @Autowired
    public ControllerConfiguration(AdminInterceptor adminInterceptor) {
        this.adminInterceptor = adminInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/rest-api-root/**"); // White list paths
                //.excludePathPatterns("/static-resource-root/**"); // Black list paths
    }
}