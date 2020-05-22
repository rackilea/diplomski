@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "mypackages")
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
        interceptor.setEntityManagerFactory(emf);
        registry.addWebRequestInterceptor(interceptor);
    }
}