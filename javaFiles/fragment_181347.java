@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    @Qualifier("repositoryExporterHandlerAdapter")
    RequestMappingHandlerAdapter repositoryExporterHandlerAdapter;

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        List<HandlerMethodArgumentResolver> customArgumentResolvers = repositoryExporterHandlerAdapter.getCustomArgumentResolvers();
        argumentResolvers.addAll(customArgumentResolvers);
    }

}